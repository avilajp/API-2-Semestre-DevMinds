package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDao {
    private String sql_table = "";
    private String sql_table2 = "";

    public void registerMateria(String MatriculadoEm, String semestre, String tipo, String problema, String empresa, String disciplina, String aluno_email_pessoal, String email_professor) {

        try (Connection con = SqlConnection.getConnection()) {

            this.sql_table = "";
            this.sql_table2 = "";
            tellApartMateria(MatriculadoEm);

            if (sql_table2.isEmpty()) {
                updateOrInsertMateria(con, sql_table, semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor);
            } else {
                updateOrInsertMateria(con, sql_table, semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor);
                updateOrInsertMateria(con, sql_table2, semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao registrar matéria !!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void tellApartMateria(String matriculadoEm) {
        if (matriculadoEm.equals("TG1")) {
            sql_table = "materia_tg1";
        } else if (matriculadoEm.equals("TG2")) {
            sql_table = "materia_tg2";
        } else {
            sql_table = "materia_tg1";
            sql_table2 = "materia_tg2";
        }
    }

    private void updateOrInsertMateria(Connection con, String sql_table, String semestre, String tipo, String problema, String empresa, String disciplina, String aluno_email_pessoal, String email_professor) throws SQLException {
        String sql_update = String.format("UPDATE sgtg.%s SET " +
                        "tipo = ?, " +
                        "problema = ?, " +
                        "empresa = ?, " +
                        "disciplina = ? " +
                        "WHERE aluno_email_pessoal = (SELECT distinct aluno_email_pessoal FROM aluno WHERE aluno_email_pessoal = ?) AND semestre = (SELECT distinct semestre FROM semestre WHERE semestre = ?)",
                sql_table);

        PreparedStatement pst;
        pst = con.prepareStatement(sql_update);
        pst.setString(1, tipo);
        pst.setString(2, problema);
        pst.setString(3, empresa);
        pst.setString(4, disciplina);
        pst.setString(5, aluno_email_pessoal);
        pst.setString(6, semestre);

        int updatedRowCount = pst.executeUpdate();

        if (updatedRowCount == 0) {
            String sql_insert = String.format(
                    "INSERT INTO sgtg.%s (semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor) " +
                            "VALUES ( (SELECT nome FROM semestre WHERE nome = ?), " +
                            "?, " +
                            "?, " +
                            "?, " +
                            "?, " +
                            "(SELECT aluno_email_pessoal FROM aluno WHERE aluno_email_pessoal = ?), " +
                            "(SELECT email_professor FROM professor WHERE email_professor = ?)" +
                            ");", sql_table);

            PreparedStatement pst2;
            pst2 = con.prepareStatement(sql_insert);
            pst2.setString(1, semestre);
            pst2.setString(2, tipo);
            pst2.setObject(3, problema);
            pst2.setObject(4, empresa);
            pst2.setObject(5, disciplina);
            pst2.setObject(6, aluno_email_pessoal);
            pst2.setObject(7, email_professor);
            pst2.executeUpdate();
        }
    }

    public List<String> getSemestreEMateria() throws SQLException, ClassNotFoundException, IndexOutOfBoundsException {
        ArrayList<String> semestreMateria = null;
        try (Connection con = SqlConnection.getConnection()) {
            String materiaTG1 = "materia_tg1";
            String materiaTG2 = "materia_tg2";
            ArrayList<String> materias = new ArrayList<>();
            materias.add(materiaTG1);
            materias.add(materiaTG2);
            String materiaDoSemestre;
            semestreMateria = new ArrayList<>();

            for (int i = 0; i < materias.size(); i++) {
                String sql_select = String.format("SELECT semestre from %s", materias.get(i));
                PreparedStatement pst;
                pst = con.prepareStatement(sql_select);
                //pst.setString(1, materias.get(i));

                ResultSet rs;
                rs = pst.executeQuery();

                ResultSetToArrayList converter = new ResultSetToArrayList();
                List listaSemestre = converter.convert(rs);


                if (materias.get(i).equals("materia_tg1")) {
                    materiaDoSemestre = "TG1";
                } else {
                    materiaDoSemestre = "TG2";
                }

                for (int j = 0; j < listaSemestre.size(); j++) {
                    if (semestreMateria.contains(listaSemestre.get(j) + " - " + materiaDoSemestre)) {
                    } else {
                        semestreMateria.add(String.format(listaSemestre.get(j) + " - %s", materiaDoSemestre));
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar Semestre e Materia !!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Crie um semestre primeiro!");
        }
        return semestreMateria;
    }
}

