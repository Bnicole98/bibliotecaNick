package br.com.udf.controller;

import br.com.udf.DatabaseConnection;
import br.com.udf.dao.UsuarioDAO;
import br.com.udf.dominio.Usuario;
import com.google.gson.Gson;

import java.util.List;

public class UsuarioController {

    public static String consultaUsuarios(){
        String query = UsuarioDAO.consulta_usuarios();

        List<Usuario> lista = UsuarioDAO.usuarios_result(
                DatabaseConnection.consultaSQL(query)
        );


        Gson gson = new Gson();
        return gson.toJson(lista);

    }

    public static String inserirUsuario(String body){
        String msgRes = "";

        Usuario user = (new Gson()).fromJson(body, Usuario.class);

        String query = UsuarioDAO.buildUsuarioInsert(user);
        boolean succes = DatabaseConnection.executeQuery(query);

        System.out.println("Resultado Sucesso:"+succes);

        msgRes =  "{\"message\":\"FIM DA OPERACAO\"}";

        return msgRes;
    }

    public static String consultarUsuarioPorId(int id){
        String query = UsuarioDAO.queryEncontrarUsuario(id);

        List<Usuario> usuario = UsuarioDAO.usuarios_result(
                DatabaseConnection.consultaSQL(query)
        );

        System.out.println(query);
        if(usuario.isEmpty()){
            return "{\"message\":\"REGISTRO NÃO ENCONTRADO\"}";
        }
        else {
            Usuario us = usuario.get(0);

            return (new Gson().toJson(us));

        }
    }

    public static String atualizarUsuarioPorId(int id, String body){
        String query = UsuarioDAO.queryEncontrarUsuario(id);

        List<Usuario> usuario = UsuarioDAO.usuarios_result(
                DatabaseConnection.consultaSQL(query)
        );
        if(usuario.isEmpty()){
            return "{\"message\":\"REGISTRO NÃO ENCONTRADO\"}";
        }else {
            Usuario us = (new Gson()).fromJson(body, Usuario.class);

            us.setId_rgm(id);

            String queryUpdate = UsuarioDAO.buildUsuarioUpdate(us);

            boolean succes = DatabaseConnection.executeQuery(queryUpdate);

            System.out.println("Resultado Sucesso:"+succes);

            return "{\"message\":\"FIM DA OPERACAO\"}";

        }
    }

    public  static String deletarUsuarioPorId(int id){
        String query = UsuarioDAO.queryEncontrarUsuario(id);

        List<Usuario> usuario = UsuarioDAO.usuarios_result(
                DatabaseConnection.consultaSQL(query)
        );
        if(usuario.isEmpty()){
            return "{\"message\":\"REGISTRO NÃO ENCONTRADO\"}";
        } else {
            String queryDelet = UsuarioDAO.buildUsuarioDelete(id);

            boolean succes = DatabaseConnection.executeQuery(queryDelet);

            System.out.println("Resultado Sucesso:"+succes);

            return "{\"message\":\"FIM DA OPERACAO\"}";
        }
    }

}
