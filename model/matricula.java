package br.edu.universidade;

import java.util.Date;

public class Matricula {
    private int idMatricula;          
    private Aluno aluno;              
    private Disciplina disciplina;    
    private Date dataMatricula;       
    private String situacao;          

    public Matricula(int idMatricula, Aluno aluno, Disciplina disciplina, Date dataMatricula, String situacao) {
        this.idMatricula = idMatricula;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.dataMatricula = dataMatricula;
        this.situacao = situacao;
    }

    public Matricula(Aluno aluno, Disciplina disciplina, Date dataMatricula) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.dataMatricula = dataMatricula;
        this.situacao = "ATIVA";
    }

    public int getIdMatricula() { return idMatricula; }
    public Aluno getAluno() { return aluno; }
    public Disciplina getDisciplina() { return disciplina; }
    public Date getDataMatricula() { return dataMatricula; }
    public String getSituacao() { return situacao; }

    public void setIdMatricula(int idMatricula) { this.idMatricula = idMatricula; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
    public void setDataMatricula(Date dataMatricula) { this.dataMatricula = dataMatricula; }
    public void setSituacao(String situacao) { this.situacao = situacao; }

    @Override
    public String toString() {
        return "Matricula{" +
                "idMatricula=" + idMatricula +
                ", aluno=" + (aluno != null ? aluno.getNome() : "Nenhum") +
                ", disciplina=" + (disciplina != null ? disciplina.getNome() : "Nenhuma") +
                ", dataMatricula=" + dataMatricula +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}

