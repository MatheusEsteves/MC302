package lab5;

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
	public AlunoGraduacao(String nome, String cpf, int estado, int curso) {
		super(nome, cpf, estado, curso);
		this.calculaAnoMaxIntegralizacao();
	}

	/*
	 * Calculo até qual ano o aluno de graduação tem para concluir o curso de
	 * graduação, com base nas normas da instituição para alunos de graduação e no
	 * ano de ingresso desse aluno na instituição.
	 */
	public void calculaAnoMaxIntegralizacao() {
		this.anoLimiteIntegralizacao = this.getAnoIngresso() + AlunoGraduacao.PRAZO_INTEGRALIZACAO;
	}

	public void imprimeDados() {
		System.out.println("ALUNO DE GRADUAÇÃO");
		super.imprimeDados();
	}
}
