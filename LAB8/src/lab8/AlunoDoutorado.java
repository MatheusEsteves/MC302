package lab7;

/*
 * Representa um aluno de doutorado, que também é um tipo de aluno de pós graduação.
 */
public class AlunoDoutorado extends AlunoPos {

	/*
	 * Prazo para integralização do curso em anos, para um aluno de doutorado.
	 */
	public static final int PRAZO_INTEGRALIZACAO = 6;

	/*
	 * Instanciamos um aluno de doutorado com todos os atributos de um aluno mais as
	 * indicações que revelam se esse doutorando tem inglês comprovado e se passou
	 * no exame de qualificação. Caso o aluno já possua algum orientador previamente
	 * existente, passamos ele como parâmetro no construtor.
	 */
	public AlunoDoutorado(String nome, String cpf, int estado, boolean isInglesComprovado,
			boolean isExameQualificacaoAprovado, Professor orientador) {

		super(nome, cpf, estado, orientador);
		this.setInglesComprovado(isInglesComprovado);
		this.setExameQualificacaoAprovado(isExameQualificacaoAprovado);
		this.calculaAnoMaxIntegralizacao();
	}

	/*
	 Construtor para caso o aluno NÃO possua algum orientador previamente cadastrado.
	*/
	public AlunoDoutorado(String nome, String cpf, int estado, boolean isInglesComprovado,
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
	 * Calculo até qual ano o doutorando tem para concluir o curso de doutorado, com
	 * base nas normas da instituição para doutorando e no ano de ingresso desse
	 * aluno na instituição.
	 */
	public void calculaAnoMaxIntegralizacao() {
		this.anoLimiteIntegralizacao = this.getAnoIngresso() + AlunoDoutorado.PRAZO_INTEGRALIZACAO;
	}

	/*
	 * Imprime os dados principais de um aluno de doutorado.
	 */
	@Override
	public void imprimeDados() {
		System.out.println("ALUNO DE DOUTORADO");
		super.imprimeDados();
		String saida = "Inglês comprovado : " + (this.isInglesComprovado ? "SIM" : "NÃO") + "\n";
		saida += "Aprovado no EQE : " + (this.isExameQualificacaoAprovado ? "SIM" : "NÃO");
		System.out.println(saida);
	}
}
