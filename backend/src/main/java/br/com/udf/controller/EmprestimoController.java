package br.com.udf.controller;

import br.com.udf.DatabaseConnection;
import br.com.udf.dao.EmprestimoDAO;
import br.com.udf.dominio.Emprestimo;
import com.google.gson.Gson;

import java.util.List;

public class EmprestimoController {
    public static String consultaEmprestimo(){
        String query = EmprestimoDAO.consulta_emprestimo();

        List<Emprestimo> emp = EmprestimoDAO.emprestimo_result(
                DatabaseConnection.consultaSQL(query)
        );

        Gson gson = new Gson();
        return gson.toJson(emp);

    }

    public static String inserirEmprestimo(String body){

        String msgRes = "";

        Emprestimo em = (new Gson()).fromJson(body, Emprestimo.class);

        String query = EmprestimoDAO.buildEmprestimoInsert(em);

        boolean succes = DatabaseConnection.executeQuery(query);

        System.out.println("Resultado Sucesso:"+succes);

        msgRes =  "{\"message\":\"FIM DA OPERACAO\"}";

        return msgRes;



    }
}
