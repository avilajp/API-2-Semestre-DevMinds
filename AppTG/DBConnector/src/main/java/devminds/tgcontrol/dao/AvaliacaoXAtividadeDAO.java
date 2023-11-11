package devminds.tgcontrol.dao;

import devminds.tgcontrol.ResultSetToArrayList;
import devminds.tgcontrol.SqlConnection;
import devminds.tgcontrol.objects.ViewObjAtividadeXAvaliacao;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AvaliacaoXAtividadeDAO {
    public ObservableList<ViewObjAtividadeXAvaliacao> getAlunosTG(String materiaSelecionada, String semestreSelecionado) throws SQLException, ClassNotFoundException {
        ObservableList<ViewObjAtividadeXAvaliacao> lista  = null;
        try(Connection con = SqlConnection.getConnection()){
            String sql_select = String.format("select distinct replace (aluno_email_pessoal, aluno_email_pessoal,(select nome from aluno where aluno_email_pessoal = %s.aluno_email_pessoal)) as nome_aluno,\n" +
                    "(select tipo where aluno_email_pessoal = %s.aluno_email_pessoal) as tipo,\n" +
                    "matriculado_em " +
                    "from %s where semestre = %s",materiaSelecionada,materiaSelecionada,materiaSelecionada,semestreSelecionado);
            PreparedStatement pst;
            pst = con.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            ResultSetToArrayList converter = new ResultSetToArrayList();
            lista = converter.converterTelaVisualizar(rs);
        }

        return lista;
    }
}
