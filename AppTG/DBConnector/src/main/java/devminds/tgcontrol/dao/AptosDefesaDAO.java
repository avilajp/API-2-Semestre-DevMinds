package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.ViewObjAlunosAptos;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AptosDefesaDAO {
    public ObservableList<ViewObjAlunosAptos> getAlunosAptos(String materia, String semestre, String semestreMateria) throws SQLException, ClassNotFoundException {
        ObservableList<ViewObjAlunosAptos> lista  = null;
        try (Connection con = SqlConnection.getConnection()){
            String sql_select = String.format("SELECT distinct replace (aluno_email_pessoal, aluno_email_pessoal,(select nome from aluno where aluno_email_pessoal = %s.aluno_email_pessoal)) as nome_aluno, tipo, " +
                    "(SELECT nome_professor from professor as av INNER JOIN %s as ati on av.email_professor  = ati.email_professor where ati.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome)) ORDER BY nome_aluno desc limit 0,1) as orientador, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 0,1) as a1, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 1,1) as a2, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 2,1) as a3, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 3,1) as a4, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 4,1) as a5, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 5,1) as a6, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 6,1) as a7, " +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as ati on av.id_atividade = ati.id_atividade and ati.%s = ? where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 7,1) as a8 " +
                    "FROM %s",materia,materia,semestreMateria,semestreMateria,semestreMateria,semestreMateria,semestreMateria,semestreMateria,semestreMateria,semestreMateria,materia);
            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            pst.setString(1, semestre);
            pst.setString(2, semestre);
            pst.setString(3, semestre);
            pst.setString(4, semestre);
            pst.setString(5, semestre);
            pst.setString(6, semestre);
            pst.setString(7, semestre);
            pst.setString(8, semestre);
            pst.executeQuery();
            ResultSet rs = pst.executeQuery();
            ResultSetToArrayList converter = new ResultSetToArrayList();
            lista = converter.converterTelaAlunosAptosDefesa(rs);

        }

        return lista;

    }
}
