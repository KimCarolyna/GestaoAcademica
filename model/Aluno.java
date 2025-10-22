package br.edu.universidade;

public class Aluno {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String disciplinaMatriculada; // NOVO CAMPO

    public Aluno(int id, String nome, String email, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nMatrícula: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nCPF: " + cpf +
                "\nDisciplina Matriculada: " + (disciplinaMatriculada != null ? disciplinaMatriculada : "Nenhuma");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDisciplinaMatriculada() {
        return disciplinaMatriculada;
    }

    public void setDisciplinaMatriculada(String disciplinaMatriculada) {
        this.disciplinaMatriculada = disciplinaMatriculada;
    }
}