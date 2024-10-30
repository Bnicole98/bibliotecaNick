package br.com.udf.dominio;

public class Emprestimo {
    private int id_emprestimo;
    private String data_emprestimo;
    private String data_devolucao;
    private int id_rgm;
    private int livro;

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public int getId_rgm() {
        return id_rgm;
    }

    public void setId_rgm(int id_rgm) {
        this.id_rgm = id_rgm;
    }

    public int getLivro() {
        return livro;
    }

    public void setLivro(int livro) {
        this.livro = livro;
    }

    public Emprestimo(int id_emprestimo, String data_emprestimo, String data_devolucao, int id_rgm, int livro) {
        this.id_emprestimo = id_emprestimo;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.id_rgm = id_rgm;
        this.livro = livro;
    }

    public Emprestimo() {
    }

    @Override
    public String toString(){
        return "Emprestimo{"+
                "id_emprestimo=" + id_emprestimo +
                ", data_emprestimo='" + data_emprestimo + '\'' +
                ", data_devolucao='" + data_devolucao + '\'' +
                ", id_rgm='" + id_rgm + '\'' +
                ", livro='" + livro + '\'' +
                '}';
    }
}


