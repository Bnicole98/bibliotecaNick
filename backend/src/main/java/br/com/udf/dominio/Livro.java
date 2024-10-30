package br.com.udf.dominio;

public class Livro {
    private int id_livro;
    private String data_publicacao;
    private String isbn;
    private String autor;
    private String editor;
    private String titulo;

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public String getData_publicacao() {
        return data_publicacao;
    }

    public void setData_publicacao(String data_publicacao) {
        this.data_publicacao = data_publicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Livro(int id_livro, String data_publicacao, String isbn, String autor, String editor, String titulo) {
        this.id_livro = id_livro;
        this.data_publicacao = data_publicacao;
        this.isbn = isbn;
        this.autor = autor;
        this.editor = editor;
        this.titulo = titulo;
    }

    public Livro() {
    }

    @Override
    public String toString(){
        return "Livro{"+
                "id_rgm=" + id_livro +
                ", data_publicacao='" + data_publicacao + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", editor='" + editor + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
