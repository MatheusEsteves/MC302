package lab8;

/*
 * Representa um aluno de mestrado, que também é um tipo de aluno de pós graduação.
 */
public class AlunoMestrado extends AlunoPos {

	/*
	 * Prazo para integralização do curso em anos, para um aluno de mestrado.
	 */
	public static final int PRAZO_INTEGRALIZACAO = 3;

	/*
	 * Instanciamos um aluno de mestrado com todos os atributos de um aluno mais as
	 * indicações que revelam se esse mestrando tem inglês comprovado e se passou no
	 * exame de qualificação. Caso o aluno já possua algum orientador previamente
	 * existente, passamos ele como parâmetro no construtor.
	 */
	public AlunoMestrado(String nome, String cpf, int estado, boolean isInglesComprovado,
			boolean isExameQualificacaoAprovado, Professor orientador) {

		super(nome, cpf, estado, orientador);
		this.setInglesComprovado(isInglesComprovado);
		this.setExameQualificacaoAprovado(isExameQualificacaoAprovado);
		this.calculaAnoMaxIntegralizacao();
	}

	/*
	 Construtor para caso o aluno NÃO possua algum orientador previamente cadastrado.
	 */
	public AlunoMestrado(String nome, String cpf, int estado, boolean isInglesComprovado,
						 boolean isExameQualificacaoAprovado) {

		super(nome, cpf, estado);
		this.setInglesComprovado(isInglesComprovado);
		this.setExameQualificacaoAprovado(isExameQualificacaoAprovado);
		this.calculaAnoMaxIntegralizacao();
	}

	public void setInglesComprovado(boolean isInglesComprovado) {
		this.isInglesComprovado = isInglesComprovado;
	}

	public void setExameQualificacaoAprovado(boolean isExameQualificacaoAprovado) {
		this.isExameQualificacaoAprovado = isExameQualificacaoAprovado;
	}

	/*
	 * Calculo até qual ano o mestrando tem para concluir o curso de mestrado, com
	 * base nas normas da instituição para mestrando e no ano de ingresso desse
	 * aluno na instituição.
	 */
	public void calculaAnoMaxIntegralizacao() {
		this.anoLimiteIntegralizacao = this.getAnoIngresso() + AlunoMestrado.PRAZO_INTEGRALIZACAO;
	}

	/*
	 * Imprime os dados principais de um aluno de mestrado.
	 */
	@Override
	public void imprimeDados() {
		System.out.println("ALUNO DE MESTRADO");
		super.imprimeDados();
		String saida = "Inglês comprovado : " + (this.isInglesComprovado ? "SIM" : "NÃO") + "\n";
		saida += "Aprovado no EQM : " + (this.isExameQualificacaoAprovado ? "SIM" : "NÃO");
		System.out.println(saida);
	}
}
