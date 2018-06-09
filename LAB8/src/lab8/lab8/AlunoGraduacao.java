package lab8;

import java.util.ArrayList;

/*
 * Representa um aluno de graduação, que possui todos os atributos de um aluno.
 */
public class AlunoGraduacao extends Aluno {

	/*
	 * Prazo para integralização do curso em anos, para um aluno de graduação.
	 */
	public static final int PRAZO_INTEGRALIZACAO = 7;

	/*
	 * Instanciamos um aluno de graduação com todos os atributos de um aluno.
	 */
	public AlunoGraduacao(String nome, String cpf, int estado) {
		super(nome, cpf, estado);
		this.calculaAnoMaxIntegralizacao();
	}

	/*
	  Método que insere esse aluno numa disciplina. Alunos de graduação podem
	  ser matriculados tanto em disciplinas de graduação quanto em disciplinas
	  de pós graduação.
	 */
	public boolean addDisciplina(Disciplina disciplina) {
		if (disciplina == null) {
			return false;
		}
		if (super.disciplinas == null) {
			super.disciplinas = new ArrayList<Disciplina>();
		}
		if (super.disciplinas.contains(disciplina)) {
			return false;
		}
		if (super.disciplinas.add(disciplina)){
			super.somaCreditos += disciplina.getCreditos();
			return true;
		}
		return false;
	}

	/*
	 Método específico para um aluno de graduação, que define seu critério de aprovação.
	 */
	@Override
	public boolean isAlunoAprovado(float nota) {
		return nota >= 5;
	}

	/*
	 * Calculo até qual ano o aluno de graduação tem para concluir o curso de
	 * graduação, com base nas normas da instituição para alunos de graduação e no
	 * ano de ingresso desse aluno na instituição.
	 */
	public void calculaAnoMaxIntegralizacao() {
		this.anoLimiteIntegralizacao = this.getAnoIngresso() + AlunoGraduacao.PRAZO_INTEGRALIZACAO;
	}

	@Override
	public void imprimeDados() {
		System.out.println("ALUNO DE GRADUAÇÃO");
		super.imprimeDados();
	}
}
