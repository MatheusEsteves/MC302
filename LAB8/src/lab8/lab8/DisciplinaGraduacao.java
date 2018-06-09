package lab8;

import java.util.ArrayList;

/*
  Disciplina específica para cursos de graduação, que podem ter apenas
  alunos de graduação matriculados.
 */
public class DisciplinaGraduacao extends Disciplina{

    public DisciplinaGraduacao(int id, String nome, int creditos, int maxAlunos) {
        super(id, nome, creditos, maxAlunos);
    }

    /*
      Método específico para uma disciplina de graduação, que só permite que alunos
      de graduação cursem disciplinas de graduação.
     */
    public boolean addAluno(AlunoGraduacao aluno) {
        if (aluno == null) {
            return false;
        }
        if (this.alunos == null) {
            this.alunos = new ArrayList<Aluno>();
        }
        if (this.alunos.contains(aluno)) {
            return false;
        }
        if (this.alunos.size() >= this.MAX_ALUNOS){
            return false;
        }
        return this.alunos.add(aluno) && aluno.addDisciplina(this);
    }
}
