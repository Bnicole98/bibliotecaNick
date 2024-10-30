package br.com.udf.dominio;

public class Usuario {
    private int id_rgm;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public int getId_rgm() {
        return id_rgm;
    }

    public void setId_rgm(int id_rgm) {
        this.id_rgm = id_rgm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Usuario(int id_rgm, String nome, String email, String telefone, String endereco) {
        this.id_rgm = id_rgm;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_rgm=" + id_rgm +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
