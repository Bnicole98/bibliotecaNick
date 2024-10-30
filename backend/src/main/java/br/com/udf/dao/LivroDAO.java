package br.com.udf.dao;

import br.com.udf.dominio.Livro;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public static String consulta_livros(){
        return "SELECT * FROM Livro;";

    }

    public static List<Livro> livro_result(ResultSet res){
        List<Livro> livros = new ArrayList<>();
        try{
            while (res.next()){
                Livro liv = new Livro();

                liv.setId_livro(res.getInt("ID_Livro"));
                liv.setData_publicacao(res.getString("Data_Publicacao"));
                liv.setIsbn(res.getString("ISBN"));
                liv.setAutor(res.getString("Autor"));
                liv.setEditor(res.getString("Editor"));
                liv.setTitulo((res.getString("Titulo")));

                livros.add(liv);

            }
            return livros;
        }catch (SQLException e){
            e.printStackTrace();
            return livros;
        }

    }

    public static String buildLivroInsert(Livro lv){
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO livro (Data_Publicacao, ISBN, Autor, Editor, Titulo) VALUES (");
        sb.append("'");
        sb.append(lv.getData_publicacao());
        sb.append("',");
        sb.append("'");
        sb.append(lv.getIsbn());
        sb.append("',");
        sb.append("'");
        sb.append(lv.getAutor());
        sb.append("',");
        sb.append("'");
        sb.append(lv.getEditor());
        sb.append("',");
        sb.append("'");
        sb.append(lv.getTitulo());
        sb.append("');");

        return sb.toString();

    }

    public static String queryEncontrarLivro(int id_livro){
        return "SELECT * FROM livro WHERE ID_Livro =" + String.valueOf(id_livro) + ";";
    }

    public static String buildLivroUpdate(Livro lv){
        StringBuilder sb = new StringBuilder();

        sb.append("UPDATE livro ");
        sb.append("SET Data_Publicacao = '");
        sb.append(lv.getData_publicacao());
        sb.append("', ISBN ='");
        sb.append(lv.getIsbn());
        sb.append("', Autor ='");
        sb.append(lv.getAutor());
        sb.append("', Editor ='");
        sb.append(lv.getEditor());
        sb.append("', Titulo ='");
        sb.append(lv.getTitulo());
        sb.append("' WHERE  ID_Livro =");
        sb.append(lv.getId_livro());
        sb.append(";");

        return sb.toString();

    }

    public static String buildLivroDelete(int id){
        return "DELETE FROM livro WHERE ID_Livro="+String.valueOf(id)+";";
    }

}
