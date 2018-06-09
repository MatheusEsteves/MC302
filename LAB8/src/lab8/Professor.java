package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Representa um professor com nome, cpf, salário e disciplinas.
 * Todo professor também é um funcionário e portanto, também 
 * é uma pessoa física.
 */
public class Professor extends Funcionario {

	private int[] disciplinas;
	private List<AlunoPos> orientandos = new ArrayList<AlunoPos>();

	public Professor() {
		super();
		this.disciplinas = new int[0];
	}

	/*
	  Construtor para caso o professor NÃO possua algum orientando previamente cadastrado.
	 */
	public Professor(String nome, String cpf, double salario, int[] disciplinas) {
		super(nome, cpf, salario);
		this.setDisciplinas(disciplinas);
	}

	/*
	  Construtor para caso o professor já possua algum orientando previamente cadastrado.
	 */
	public Professor(String nome, String cpf, double salario, int[] disciplinas, AlunoPos orientando) {
		this(nome, cpf, salario, disciplinas);
		this.orientandos.add(orientando);
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

	@Override
	public void imprimeDados(){
		super.imprimeDados();
		/*
		 * Se o tipo do funcionário for um professor, exibiremos as disciplinas que
		 * leciona.
		 */
		System.out.println("Função do funcionário : PROFESSOR");
		System.out.println("Disciplinas : " + Arrays.toString(this.disciplinas));
	}
}
