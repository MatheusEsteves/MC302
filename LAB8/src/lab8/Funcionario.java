package lab7;

/*
 * Classe que representa um funcionário na universidade, com seu nome, CPF e salário.
 * Todo funcionário também é uma pessoa física.
 */
public class Funcionario extends PessoaFisica {

	private double salario;

	public Funcionario() {
		super();
		this.salario = 0;
	}

	public Funcionario(String nome, String cpf, double salario) {
		super(nome, cpf);
		this.setSalario(salario);
	}

	/*
	 * Setamos o salário do funcionário, que não poderá ser menor ou igual a zero.
	 */
	private void setSalario(double salario) {
		if (salario <= 0) {
			System.out.println("Salário incorreto");
		} else {
			this.salario = salario;
		}
	}

	public double getSalario() {
		return this.salario;
	}

	@Override
	public void imprimeDados(){
		super.imprimeDados();
		/*
		 * Se o tipo da pessoa for um funcionário, exibiremos por padrão o seu salário,
		 * indepedentemente do tipo de funcionário que estamos tratando.
		 */
		System.out.println("Classificação : FUNCIONÁRIO");
		System.out.println("Salário : " + this.salario);

	}
}
