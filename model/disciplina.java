package br.edu.universidade;

public class Disciplina {
    private int idDisciplina;
    private String codigo;
    private String nome;
    private int cargaHoraria;
    private String periodo;
    private Professor professor; 

    public Disciplina(int idDisciplina, String codigo, String nome, int cargaHoraria, String periodo, Professor professor) {
        this.idDisciplina = idDisciplina;
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.periodo = periodo;
        this.professor = professor;
    }

    public Disciplina(String codigo, String nome, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.professor = professor;
    }

    public int getIdDisciplina() { return idDisciplina; }
    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getCargaHoraria() { return cargaHoraria; }
    public String getPeriodo() { return periodo; }
    public Professor getProfessor() { return professor; }

    public void setIdDisciplina(int idDisciplina) { this.idDisciplina = idDisciplina; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    @Override
    public String toString() {
        return "Disciplina{" +
                "idDisciplina=" + idDisciplina +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                ", periodo='" + periodo + '\'' +
                ", professor=" + (professor != null ? professor.getNome() : "Nenhum") +
                '}';
    }
}
