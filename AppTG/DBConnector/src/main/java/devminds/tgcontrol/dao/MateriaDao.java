package devminds.tgcontrol.dao;

import devminds.tgcontrol.SqlConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MateriaDao {
    public void registerMateria (String semestre, String tipo, String problema, String empresa, String disciplina, String aluno_email_pessoal, String email_professor) throws SQLException, ClassNotFoundException {
        try (Connection con = SqlConnection.getConnection()) {
            DatabaseMetaData dbmd;

            if(disciplina.equals("TG1")) {
                String sql_update = "UPDATE sgtg.materia_tg1 SET semestre = ?, tipo = ?, problema  = ?, empresa = ?, disciplina = ? WHERE aluno_email_pessoal = ?";
                PreparedStatement pst;
                pst = con.prepareStatement(sql_update);
                pst.setString(1, semestre);
                pst.setString(2, tipo);
                pst.setString(3, problema);
                pst.setString(4, empresa);
                pst.setString(5, disciplina);
                pst.setString(6, aluno_email_pessoal);

                int updatedRowCount = pst.executeUpdate();

                if (updatedRowCount == 0) {
                    String sql_insert = "INSERT INTO sgtg.materia_tg1 (semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor) VALUES (?, ?, ?, ?, ?, SELECT aluno_email_pessoal FROM sgtg.aluno WHERE aluno_email_pessoal = ?, SELECT email_professor FROM sgtg.professor WHERE  email_professor = ?)";
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
            if (disciplina.equals("TG2")) {
                String sql_update = "UPDATE sgtg.materia_tg2 SET semestre = ?, tipo = ?, problema  = ?, empresa = ?, disciplina = ? where aluno_email_pessoal = ?";
                PreparedStatement pst;
                pst = con.prepareStatement(sql_update);
                pst.setString(1, semestre);
                pst.setString(2, tipo);
                pst.setString(3, problema);
                pst.setString(4, empresa);
                pst.setString(5, disciplina);
                pst.setString(6, aluno_email_pessoal);

                int updatedRowCount = pst.executeUpdate();

                if (updatedRowCount == 0) {
                    String sql_insert = "INSERT INTO sgtg.materia_tg2 (semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor) VALUES (?, ?, ?, ?, ?, ?, ?)";
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


                } else {
                    String sql_update = "UPDATE sgtg.materia_tg1 SET semestre = ?, tipo = ?, problema  = ?, empresa = ?, disciplina = ? where aluno_email_pessoal = ?";
                    PreparedStatement pst;
                    pst = con.prepareStatement(sql_update);
                    pst.setString(1, semestre);
                    pst.setString(2, tipo);
                    pst.setString(3, problema);
                    pst.setString(4, empresa);
                    pst.setString(5, disciplina);
                    pst.setString(6, aluno_email_pessoal);

                    int updatedRowCount = pst.executeUpdate();

                    if (updatedRowCount == 0) {
                        String sql_insert = "INSERT INTO sgtg.materia_tg1 (semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor) VALUES (?, ?, ?, ?, ?, ?, ?)";
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

                    String sql_update2 = "UPDATE sgtg.materia_tg2 SET semestre = ?, tipo = ?, problema  = ?, empresa = ?, disciplina = ? where aluno_email_pessoal = ?";
                    PreparedStatement pst2;
                    pst2 = con.prepareStatement(sql_update);
                    pst2.setString(1, semestre);
                    pst2.setString(2, tipo);
                    pst2.setString(3, problema);
                    pst2.setString(4, empresa);
                    pst2.setString(5, disciplina);
                    pst2.setString(6, aluno_email_pessoal);

                    int updatedRowCount2 = pst2.executeUpdate();

                    if (updatedRowCount2 == 0) {
                        String sql_insert = "INSERT INTO sgtg.materia_tg2 (semestre, tipo, problema, empresa, disciplina, aluno_email_pessoal, email_professor) VALUES (?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pst3;
                        pst3 = con.prepareStatement(sql_insert);
                        pst3.setString(1, semestre);
                        pst3.setString(2, tipo);
                        pst3.setObject(3, problema);
                        pst3.setObject(4, empresa);
                        pst3.setObject(5, disciplina);
                        pst3.setObject(6, aluno_email_pessoal);
                        pst3.setObject(7, email_professor);
                        pst3.executeUpdate();
                    }
                }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao registrar matéria !!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

