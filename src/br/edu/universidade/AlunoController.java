package br.edu.universidade;

import java.util.ArrayList;
import java.util.List;

public class AlunoController {
    private List<Aluno> alunos;

    public AlunoController() {
        this.alunos = new ArrayList<>();
    }

    public void cadastrarAluno(int id, String nome, String email) {
        Aluno aluno = new Aluno(id, nome, email);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}
