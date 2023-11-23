package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.DTOFechamento;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FechamentoDAO {
    public ObservableList<DTOFechamento> getAllSemestre() throws SQLException, ClassNotFoundException {
        ObservableList<DTOFechamento> lista  = null;
        try(Connection con = SqlConnection.getConnection()){
            String sql_select = String.format("SELECT distinct replace (aluno_email_pessoal, aluno_email_pessoal,(select nome from aluno where aluno_email_pessoal = materia_tg1.aluno_email_pessoal)) as nome_aluno,\n" +
                    "tipo,\n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 0,1) as a1, \n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 1,1) as a2,\n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 2,1) as a3,\n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 3,1) as a4,\n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 4,1) as a5,\n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 5,1) as a6,\n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 6,1) as a7,\n" +
                    "(SELECT nota from avaliacao as av INNER JOIN atividade as at on av.id_atividade = at.id_atividade where av.aluno_email_pessoal = replace (nome_aluno,nome_aluno,(select aluno_email_pessoal from aluno where nome_aluno = aluno.nome))  ORDER BY nome_aluno desc limit 7,1) as a8\n" +
                    "FROM materia_tg1;\n");
            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            ResultSetToArrayList converter = new ResultSetToArrayList();
            lista = converter.converterTelaFechamento(rs);
        }

        return lista;
    }
}
