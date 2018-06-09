package lab8;

import java.util.ArrayList;

/*
  Disciplina específica para cursos de pós graduação, que podem ter tanto
  alunos de graduação quanto alunos de pós graduação.
 */
public class DisciplinaPos extends Disciplina{

    public DisciplinaPos(int id, String nome, int creditos, int maxAlunos) {
        super(id, nome, creditos, maxAlunos);
    }

    /*
      Método específico para uma disciplina de pós graduação, que permite
      tanto alunos de graduação quanto alunos de pós graduação.
     */
    public boolean addAluno(Aluno aluno) {
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
        if (aluno instanceof AlunoGraduacao) {
            return this.alunos.add(aluno) && ((AlunoGraduacao)aluno).addDisciplina(this);
        }
        if (aluno instanceof AlunoPos){
            return this.alunos.add(aluno) && ((AlunoPos)aluno).addDisciplina(this);
        }
        return false;
    }
}
