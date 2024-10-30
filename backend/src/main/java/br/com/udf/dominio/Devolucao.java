package br.com.udf.dominio;

public class Devolucao {
    private int id_devolucao;
    private String data_devolucao;
    private int id_emprestimo;

    public int getId_devolucao() {
        return id_devolucao;
    }

    public void setId_devolucao(int id_devolucao) {
        this.id_devolucao = id_devolucao;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public int getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(int id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Devolucao(int id_devolucao, String data_devolucao, int id_emprestimo) {
        this.id_devolucao = id_devolucao;
        this.data_devolucao = data_devolucao;
        this.id_emprestimo = id_emprestimo;
    }

    public Devolucao() {
    }

    @Override
    public String toString() {
        return "Devolucao{" +
                "id_devolucao=" + id_devolucao +
                ", data_devolucao='" + data_devolucao + '\'' +
                ", id_emprestimo=" + id_emprestimo +
                '}';
    }
}
