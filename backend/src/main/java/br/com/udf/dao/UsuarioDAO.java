package br.com.udf.dao;

import br.com.udf.dominio.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public static String consulta_usuarios(){
        return "SELECT * FROM usuario;";
    }

    public static List<Usuario> usuarios_result(ResultSet res){
        List<Usuario> users = new ArrayList<>();
        try{
            while (res.next()){

                Usuario us = new Usuario();

                us.setId_rgm(res.getInt("ID_RGM"));
                us.setNome(res.getString("Nome"));
                us.setEmail(res.getString("Email"));
                us.setTelefone(res.getString("Telefone"));
                us.setEndereco(res.getString("Endereco"));

                users.add(us);

            }
            return users;
        }catch(SQLException e){
            e.printStackTrace();
            return users;

        }

    }

    public static String buildUsuarioInsert(Usuario us){
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO usuario ( Nome, Email, Telefone, Endereco) VALUES (");
        sb.append("'");
        sb.append(us.getNome());
        sb.append("',");
        sb.append("'");
        sb.append(us.getEmail());
        sb.append("',");
        sb.append("'");
        sb.append(us.getTelefone());
        sb.append("',");
        sb.append("'");
        sb.append(us.getEndereco());
        sb.append("');");

        return sb.toString();
    }

    public static String queryEncontrarUsuario(int id_usuario){
        return "SELECT * FROM usuario WHERE ID_RGM =" + String.valueOf(id_usuario) + ";";
    }

    public static String buildUsuarioUpdate(Usuario us){
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE usuario ");
        sb.append("SET Nome = '");
        sb.append(us.getNome());
        sb.append("', Email ='");
        sb.append(us.getEmail());
        sb.append("', Telefone ='");
        sb.append(us.getTelefone());
        sb.append("', Endereco ='");
        sb.append(us.getEndereco());
        sb.append("' WHERE ID_RGM =");
        sb.append(us.getId_rgm());
        sb.append(";");

        return sb.toString();
    }

    public static String buildUsuarioDelete(int id){
        return "DELETE FROM usuario WHERE ID_RGM="+ String.valueOf(id)+";";
    }

}
