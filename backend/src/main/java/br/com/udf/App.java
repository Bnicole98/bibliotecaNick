package br.com.udf;
import br.com.udf.controller.DevolucaoController;
import br.com.udf.controller.EmprestimoController;
import br.com.udf.controller.LivroController;
import br.com.udf.controller.UsuarioController;
import br.com.udf.dominio.Devolucao;
import br.com.udf.dominio.Emprestimo;
import br.com.udf.dominio.Livro;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class App{


    public static void main( String[] args ){

        port(8080);

        get("/bibliotecaNick/usuario/list",(req,res)-> UsuarioController.consultaUsuarios());
        get("/bibliotecaNick/usuario/:id",(req,res)-> UsuarioController.consultarUsuarioPorId(Integer.parseInt(req.params("id"))));
        post("/bibliotecaNick/usuario/inserir",(req,res)->UsuarioController.inserirUsuario(req.body()));
        put("/bibliotecaNick/usuario/atualizar/:id",(req,res)->UsuarioController.atualizarUsuarioPorId(
        Integer.parseInt(req.params("id")),
                req.body()
        ));
        put("/bibliotecaNick/usuario/delete/:id", (req, res)->UsuarioController.deletarUsuarioPorId(Integer.parseInt(req.params("id"))));


        get("/bibliotecaNick/livro/list",(req,res)-> LivroController.consultaLivro());
        get("/bibliotecaNick/livro/:id",(req,res)-> LivroController.consultarLivroPorId(Integer.parseInt(req.params("id"))));
        post("/bibliotecaNick/livro/inserir",(req,res)->LivroController.inserirLivro(req.body()));

        put("/bibliotecaNick/livro/atualizar/:id",(req,res)->LivroController.atualizarLivroPorId(
                Integer.parseInt(req.params("id")),
                req.body()
        ));
        put("/bibliotecaNick/livro/delete/:id", (req, res)->LivroController.deletarlivroPorId(Integer.parseInt(req.params("id"))));


        get("/bibliotecaNick/emprestimo/list",(req,res)-> EmprestimoController.consultaEmprestimo());
        post("/bibliotecaNick/emprestimo/inserir",(req,res)->EmprestimoController.inserirEmprestimo(req.body()));


        get("/bibliotecaNick/devolucao/list",(req,res)-> DevolucaoController.consultaDevolucao());
        post("/bibliotecaNick/devolucao/inserir",(req,res)->DevolucaoController.inserirDevolucao(req.body()));









        notFound((req,res)->{

            res.type("application/json");
            return "{\"message\":\"NAO ENCONTROU NADA\"}";
        });


    }


}
