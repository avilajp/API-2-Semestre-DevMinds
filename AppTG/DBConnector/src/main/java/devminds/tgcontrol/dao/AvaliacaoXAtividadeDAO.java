package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.Atividade;
import devminds.tgcontrol.objects.Avaliacao;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoXAtividadeDAO {
    public ObservableList<ViewObjAtividadeXAvaliacao> getAvaliacaoXAtividade() throws SQLException, ClassNotFoundException {
        ObservableList<ViewObjAtividadeXAvaliacao> lista  = null;
        try(Connection con = SqlConnection.getConnection()){
            String sql_select = "select distinct replace (aluno_email_pessoal, aluno_email_pessoal,(select nome from aluno where aluno_email_pessoal = materia_tg1.aluno_email_pessoal)) as nome_aluno,\n" +
                    "(select tipo where aluno_email_pessoal = materia_tg1.aluno_email_pessoal) as tipo,\n" +
                    "(select nota from avaliacao where id_atividade = 16 and aluno_email_pessoal = materia_tg1.aluno_email_pessoal) as A1,\n" +
                    "(select nota from avaliacao where id_atividade = 17 and aluno_email_pessoal = materia_tg1.aluno_email_pessoal) as A2,\n" +
                    "(select nota from avaliacao where id_atividade = 18 and aluno_email_pessoal = materia_tg1.aluno_email_pessoal) as A3,\n" +
                    "(select nota from avaliacao where id_atividade = 19 and aluno_email_pessoal = materia_tg1.aluno_email_pessoal) as A4\n" +
                    "from materia_tg1";
            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            ResultSetToArrayList converter = new ResultSetToArrayList();
            lista = converter.converterTelaVisualizar(rs);
        }

        return lista;
    }
}
