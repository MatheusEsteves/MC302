package lab6;

/*
 * Representa um aluno genérico da pós graduação, que poderá possuir
 * várias sub-divisões conforme o tipo de pós-graduando.
 */
public class AlunoPos extends Aluno {

	protected boolean isInglesComprovado;
	protected boolean isExameQualificacaoAprovado;

	public AlunoPos(String nome, String cpf, int estado) {
		super(nome, cpf, estado);
	}

	/*
	 * Imprime os dados principais de um aluno da pós graduação.
	 */
	public void imprimeDados() {
		super.imprimeDados();
	}
}
