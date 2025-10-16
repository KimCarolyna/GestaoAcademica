package br.edu.universidade;

public class Professor {
    private int idProfessor;
    private String nome;
    private String cpf;
    private String formacao;
    private String areaAtuacao;
    private String email;
    private String telefone;
    private double remuneracao;

    public Professor(int idProfessor, String nome, String cpf, String email) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public int getIdProfessor() { return idProfessor; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public double getRemuneracao() { return remuneracao; }
    
    public void setIdProfessor(int idProfessor) { this.idProfessor = idProfessor; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setFormacao(String formacao) { this.formacao = formacao; }
    public void setAreaAtuacao(String areaAtuacao) { this.areaAtuacao = areaAtuacao; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setRemuneracao(double remuneracao) { this.remuneracao = remuneracao; }
}