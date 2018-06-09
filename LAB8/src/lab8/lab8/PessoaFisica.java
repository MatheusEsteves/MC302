package lab8;

/*
 * Representa uma pessoa física genérica, com nome e cpf.
 */
public abstract class PessoaFisica {

	private String nome;
	private String cpf;

	public PessoaFisica() {
		this.nome = "";
		this.cpf = "";
	}

	public PessoaFisica(String nome, String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
	}

	/*
	 * Setamos o nome da pessoa, que deve ser obrigatoriamente preenchido com algum
	 * caracter diferente de espaço.
	 */
	public void setNome(String nome) {
		if (nome != null && !nome.trim().equals("")) {
			this.nome = nome;
		} else {
			System.out.println("Nome da pessoa física inválido.");
		}
	}

	public String getNome() {
		return this.nome;
	}

	/*
	 * Setamos o CPF da pessoa, que deve ser preenchido obrogatoriamente com 11
	 * caracteres.
	 */
	public void setCpf(String cpf) {
		if (cpf != null && !cpf.trim().equals("") && cpf.length() == 11) {
			this.cpf = cpf;
		} else {
			System.out.println("CPF da pessoa física inválido.");
		}
	}

	public String getCpf() {
		return this.cpf;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other instanceof PessoaFisica) {
			PessoaFisica pessoaFisica = (PessoaFisica) other;
			return this.cpf.equals(pessoaFisica.getCpf());
		}
		return false;
	}

	/*
	 * Imprime os dados principais da pessoa física.
	 */
	public void imprimeDados() {
		String saida = "Nome : " + this.nome + " , CPF : " + this.cpf;
		System.out.println(saida);
	}
}
