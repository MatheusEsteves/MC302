package lab7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 Classe que controla todas as solicitações de matriculas dos alunos nas disciplinas.
 Armazenamos todas as solicitações em uma lista para serem processadas em seguida.
 */
public class ControladorDeMatricula {

    private List<SolicitacaoMatricula> solicitacoesMatricula;

    public ControladorDeMatricula(){
        this.solicitacoesMatricula = new ArrayList<SolicitacaoMatricula>();
    }

    /*
        Armazenamos uma solicitação de matrícula de um aluno em uma disciplina,
        para ser processada posteriormente.
     */
    public void solicitarMatricula(Disciplina disciplina, Aluno aluno){
        if (disciplina == null){
            System.out.println("Disciplina nula ao solicitar matrícula");
        }
        else
            if (aluno == null){
                System.out.println("Aluno nulo ao solicitar matrícula");
            }
            else {
                if (this.solicitacoesMatricula == null) {
                    this.solicitacoesMatricula = new ArrayList<SolicitacaoMatricula>();
                }
                this.solicitacoesMatricula.add(new SolicitacaoMatricula(disciplina, aluno));
            }
    }

    /*
     Excluimos todas as solicitações anteriores para as novas serem processadas, com base no
     Iterator.
     */
    public void refazerSolicitacoesMatricula(){
        Iterator<SolicitacaoMatricula> iterator = this.solicitacoesMatricula.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

    /*
      Processamos todas as solitações de matrículas que estão armazenadas na lista. Para
      cada solicitação, matriculamos o aluno na disciplina, caso ele ainda possua direito
      a creditos, conforme o limite de créditos para o curso em que o aluno está matriculado.
     */
    public void processarSolicitacoesMatricula(){
        if (this.solicitacoesMatricula != null){
            for (SolicitacaoMatricula solicitacaoMatricula : this.solicitacoesMatricula) {
                Disciplina disciplina = solicitacaoMatricula.getDisciplina();
                Aluno aluno = solicitacaoMatricula.getAluno();
                Curso curso = aluno.getCurso();
                if (curso != null){
                    if (aluno.getSomaCreditos() + disciplina.getCreditos() <= curso.getLimiteCreditos()){
                        disciplina.addAluno(aluno);
                    }
                }
            }
        }
    }

    /*
     Classe interna à classe ControladorDeMatricula, para armazenar os dados de uma solicitação
     de matrícula. São armazenados a disciplina e o aluno.
     */
    private class SolicitacaoMatricula{
        private Disciplina disciplina;
        private Aluno aluno;

        public SolicitacaoMatricula(Disciplina disciplina, Aluno aluno) {
            this.disciplina = disciplina;
            this.aluno = aluno;
        }

        public Disciplina getDisciplina(){
            return this.disciplina;
        }

        public Aluno getAluno(){
            return this.aluno;
        }
    }
}
