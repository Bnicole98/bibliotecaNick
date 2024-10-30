package br.com.udf.controller;

import br.com.udf.DatabaseConnection;
import br.com.udf.dao.LivroDAO;
import br.com.udf.dominio.Livro;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroController {
    public static String consultaLivro(){
        String query = LivroDAO.consulta_livros();

        List<Livro> lista = LivroDAO.livro_result(
                DatabaseConnection.consultaSQL(query)
        );

        Gson gson = new Gson();
        return gson.toJson(lista);

    }

    public static String inserirLivro(String body){
        String msgRes = "";

        Livro lv = (new Gson()).fromJson(body, Livro.class);

        String query = LivroDAO.buildLivroInsert(lv);
        boolean succes = DatabaseConnection.executeQuery(query);

        System.out.println("Resultado Sucesso:"+succes);

        msgRes =  "{\"message\":\"FIM DA OPERACAO\"}";

        return msgRes;
    }

    public static String consultarLivroPorId(int id){
        String query = LivroDAO.queryEncontrarLivro(id);

        List<Livro> lista = LivroDAO.livro_result(
                DatabaseConnection.consultaSQL(query)
        );

        System.out.println(query);
        if(lista.isEmpty()){
            return "{\"message\":\"REGISTRO NÃO ENCONTRADO\"}";

        }else {

            Livro lv = lista.get(0);

            return (new Gson()).toJson(lv);

        }
    }

    public static String atualizarLivroPorId(int id, String body){

        String query = LivroDAO.queryEncontrarLivro(id);

        List<Livro> lista = LivroDAO.livro_result(
                DatabaseConnection.consultaSQL(query)
        );
        if(lista.isEmpty()){
            return "{\"message\":\"REGISTRO NÃO ENCONTRADO\"}";

        }else {

            Livro lv = (new Gson()).fromJson(body, Livro.class);

            lv.setId_livro(id);

            String queryUpdate = LivroDAO.buildLivroUpdate(lv);

            boolean succes = DatabaseConnection.executeQuery(queryUpdate);

            System.out.println("Resultado Sucesso:"+succes);

            return "{\"message\":\"FIM DA OPERACAO\"}";

        }
    }

    public static String deletarlivroPorId(int id){
        String query = LivroDAO.queryEncontrarLivro(id);

        List<Livro> livro = LivroDAO.livro_result(
                DatabaseConnection.consultaSQL(query)
        );
        if(livro.isEmpty()){
            return "{\"message\":\"REGISTRO NÃO ENCONTRADO\"}";
        }else {
            String queryDelet = LivroDAO.buildLivroDelete(id);

            boolean succes = DatabaseConnection.executeQuery(queryDelet);

            System.out.println("Resultado Sucesso:"+succes);

            return "{\"message\":\"FIM DA OPERACAO\"}";
        }
    }
}
