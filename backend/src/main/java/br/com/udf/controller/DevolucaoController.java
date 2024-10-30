package br.com.udf.controller;

import br.com.udf.DatabaseConnection;
import br.com.udf.dao.DevolucaoDAO;
import br.com.udf.dominio.Devolucao;
import com.google.gson.Gson;

import java.util.List;

public class DevolucaoController {
    public static String consultaDevolucao(){
        String query = DevolucaoDAO.consulta_devolucao();

        List<Devolucao> devolucaoList = DevolucaoDAO.devolucao_result(
                DatabaseConnection.consultaSQL(query)
        );
        Gson gson = new Gson();
        return gson.toJson(devolucaoList);
    }

    public static String inserirDevolucao(String body){
        String msgRes = "";

        Devolucao dv = (new Gson()).fromJson(body, Devolucao.class);

        String query = DevolucaoDAO.buildDevolucaoInsert(dv);

        boolean succes = DatabaseConnection.executeQuery(query);

        System.out.println("Resultado Sucesso:"+succes);

        msgRes =  "{\"message\":\"FIM DA OPERACAO\"}";

        return msgRes;
    }
}
