package lab8;

/*
 * Representa um segurança com nome, cpf e período de plantão.
 * Todo segurança também é um funcionário, portanto também é
 * uma pessoa física.
 */
public class Seguranca extends Funcionario {

	private String periodoPlantao;

	public Seguranca() {
		super();
		this.periodoPlantao = "";
	}

	public Seguranca(String nome, String cpf, double salario, String periodoPlantao) {
		super(nome, cpf, salario);
		this.setPeriodoPlantao(periodoPlantao);
	}

	public void setPeriodoPlantao(String periodoPlantao) {
		if (periodoPlantao == null || periodoPlantao.trim().equals("")) {
			System.out.println("Período do plantão não fornecido");
		} else {
			this.periodoPlantao = periodoPlantao;
		}
	}

	public String getPeriodoPlantao() {
		return this.periodoPlantao;
	}

	@Override
	public void imprimeDados(){
		super.imprimeDados();
		System.out.println("Função do funcionário : SEGURANÇA");
		System.out.println("Período do plantão : " + this.periodoPlantao);
	}
}
