package lab7;

import java.util.ArrayList;
import java.util.List;

/*
 Classe que representa um curso na instituição, o qual possuirá um limite para o
 número de créditos que um determinado aluno pode completar por semestre, um nome,
 uma lista de disciplinas associadas ao curso e uma lista de alunos matriculados
 nesse curso.
 */
public class Curso {

    private final int LIMITE_CREDITOS;
    private String nome;
    private List<Disciplina> disciplinas;
    private List<Aluno> alunos;

    public Curso(String nome, int limiteCreditos){
        this.setNome(nome);
        this.alunos = new ArrayList<Aluno>();
        this.disciplinas = new ArrayList<Disciplina>();
        this.LIMITE_CREDITOS = limiteCreditos;
        /*
            Toda que vez que um curso for instanciado, ele será armazenado
            em um repositório de cursos, o qual guarda uma lista de cursos.
         */
        RepositorioDeCursos.addCurso(this);
    }

    public void setNome(String nome){
        if (nome == null){
            System.out.println("Nome do aluno nulo");
        }
        else{
            this.nome = nome;
        }
    }

    public String getNome(){
        return this.nome;
    }

    public int getLimiteCreditos(){
        return this.LIMITE_CREDITOS;
    }

    public void addDisciplina(Disciplina disciplina){
        if (disciplina == null){
            System.out.println("Disciplina nula para relacionar ao curso");
        }
        else{
            if (this.disciplinas == null){
                this.disciplinas = new ArrayList<Disciplina>();
            }
            this.disciplinas.add(disciplina);
        }
    }

    public void removeDisciplina(Disciplina disciplina){
        if (disciplina == null){
            System.out.println("Disciplina nula para remover do curso");
        }
        if (this.disciplinas == null || !this.disciplinas.remove(disciplina)){
            System.out.println("Essa disciplina não está relacionado à este curso");
        }
    }

    /*
        Matriculamos um aluno nesse curso, caso ele já não esteja matriculado.
        Para isso, adicionamos o aluno na lista de alunos do curso.
     */
    public void matricularAluno(Aluno aluno){
        if (aluno == null){
            System.out.println("Aluno nulo para matricular no curso");
        }
        else{
            if (this.alunos == null){
                this.alunos = new ArrayList<Aluno>();
            }
            if (this.alunos.contains(aluno)){
                System.out.println("Aluno cujo CPF é " + aluno.getCpf() + " já está matriculado no curso " + this.nome);
            }
            else{
                if (this.alunos.add(aluno)){
                    aluno.addCurso(this);
                }
            }
        }
    }

    /*
        Removemos o aluno da lista de alunos do curso.
     */
    public void desmatricularAluno(Aluno aluno) {
        if (aluno == null) {
            System.out.println("Aluno nulo para desmatricular no curso");
        } else {
            if (this.alunos == null || !this.alunos.remove(aluno)) {
                System.out.println("Esse aluno não está matriculado nesse curso");
            }
            else{
                aluno.removeCurso(this);
            }
        }
    }

    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        Curso curso = (Curso) other;
        if (this.nome.equals(curso.getNome())){
            return true;
        }
        return false;
    }
}
