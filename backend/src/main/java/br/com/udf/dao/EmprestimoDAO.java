package br.com.udf.dao;
import br.com.udf.dominio.Emprestimo;
import br.com.udf.dominio.Livro;
import org.w3c.dom.ls.LSException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDAO {
    public static String consulta_emprestimo(){
        return "SELECT * FROM emprestimo;";

    }

    public static List<Emprestimo> emprestimo_result(ResultSet res){
        List<Emprestimo> emp = new ArrayList<>();
        try {
            while (res.next()){
                Emprestimo em = new Emprestimo();

                em.setId_emprestimo(res.getInt("ID_Emprestimo"));
                em.setData_emprestimo(res.getString("Data_Emprestimo"));
                em.setData_devolucao(res.getString("Data_Prevista_Devolucao"));
                em.setId_rgm(res.getInt("ID_RGM"));
                em.setLivro(res.getInt("ID_Livro"));

                emp.add(em);

            }
            return emp;

        }catch(SQLException e){
            e.printStackTrace();
            return emp;

        }
    }

    public static String buildEmprestimoInsert(Emprestimo em){
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO emprestimo (Data_Emprestimo, Data_Prevista_Devolucao, ID_RGM, ID_Livro) VALUES (");
        sb.append("'");
        sb.append(em.getData_emprestimo());
        sb.append("',");
        sb.append("'");
        sb.append(em.getData_devolucao());
        sb.append("',");
        sb.append(em.getId_rgm());
        sb.append(",");
        sb.append(em.getLivro());
        sb.append(");");

        return sb.toString();
    }

}
