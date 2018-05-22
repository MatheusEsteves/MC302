package lab7;

/*
 * Representa um professor com nome, cpf, salário e disciplinas.
 * Todo professor também é um funcionário e portanto, também 
 * é uma pessoa física.
 */
public class Professor extends Funcionario {

	private int[] disciplinas;

	public Professor() {
		super();
		this.disciplinas = new int[0];
	}

	public Professor(String nome, String cpf, double salario, int[] disciplinas) {
		super(nome, cpf, salario);
		this.setDisciplinas(disciplinas);
	}

	public void setDisciplinas(int[] disciplinas) {
		if (disciplinas == null || disciplinas.length == 0) {
			System.out.println("Disciplinas não fornecidas");
		} else {
			this.disciplinas = disciplinas;
		}
	}

	public int[] getDisciplinas() {
		return this.disciplinas;
	}
}
