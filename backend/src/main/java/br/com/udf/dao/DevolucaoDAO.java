package br.com.udf.dao;

import br.com.udf.dominio.Devolucao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevolucaoDAO {
    public static String consulta_devolucao(){
        return "SELECT * FROM devolucao;";

    }
    public static List<Devolucao> devolucao_result(ResultSet res){
        List<Devolucao> dev = new ArrayList();

        try {
            while (res.next()){
                Devolucao dv = new Devolucao();

                dv.setId_devolucao(res.getInt("ID_Devolucao"));
                dv.setData_devolucao(res.getString("Data_Devolucao"));
                dv.setId_emprestimo(res.getInt("ID_Emprestimo"));

                dev.add(dv);
            }
            return dev;

        }catch (SQLException e){
            e.printStackTrace();
            return dev;

        }
    }

    public static String buildDevolucaoInsert(Devolucao dv){
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO devolucao( Data_Devolucao,  ID_Emprestimo) VALUES (");
        sb.append("'");
        sb.append(dv.getData_devolucao());
        sb.append("',");
        sb.append(dv.getId_emprestimo());
        sb.append(");");

        return sb.toString();
    }


}
