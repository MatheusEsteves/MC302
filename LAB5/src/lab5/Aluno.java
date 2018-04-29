package lab5;

import java.util.ArrayList;
import java.util.List;

import mc302ef.GerenciadorAlunos;

/*
 * Representa um aluno com nome, cpf, matrícula, estado, curso, ano 
 * de ingresso na instituição e as disciplinas que cursa. Além disso
 * temo um campo chamado anoLimiteIntegralizacao que é configurado
 * a partir das subclasses de Alunos. Todo aluno também é uma pessoa física.
 */
public class Aluno extends PessoaFisica {

	public static final int ATIVO = 1;
	public static final int INATIVO = 2;
	public static final int SUSPENSO = 3;

	private int matricula;
	private int estado;
	private int curso;
	private int anoIngresso;
	private List<Disciplina> disciplinas;

	protected int anoLimiteIntegralizacao;

	public Aluno() {
		super();
		this.matricula = 0;
		this.estado = Aluno.INATIVO;
		this.curso = 0;
		this.anoIngresso = 0;
		this.disciplinas = new ArrayList<Disciplina>();
	}

	public Aluno(String nome, String cpf, int estado, int curso) {
		super(nome, cpf);
		this.setEstado(estado);
		this.setCurso(curso);
		this.gerarMatricula();
		this.disciplinas = new ArrayList<Disciplina>();
		/*
		 * Geramos aleatoriamente um ano de ingresso na instituição para o aluno.
		 */
		this.anoIngresso = GerenciadorAlunos.getAnoIngressoRandom();
	}

	/*
	 * Caso a disciplina ainda não esteja associada à este aluno, adicionamos ela na
	 * lista de disciplinas.
	 */
	public boolean addDisciplina(Disciplina disciplina) {
		if (disciplina == null) {
			return false;
		}
		if (this.disciplinas == null) {
			this.disciplinas = new ArrayList<Disciplina>();
		}
		if (this.disciplinas.contains(disciplina)) {
			return false;
		}
		return this.disciplinas.add(disciplina);
	}

	public boolean removeDisciplina(Disciplina disciplina) {
		if (disciplina != null && this.disciplinas != null) {
			return this.disciplinas.remove(disciplina);
		}
		return false;
	}

	/*
	 * Gera um número de matrícula único para esse aluno com base no
	 * GeradorMatricula.
	 */
	private void gerarMatricula() {
		this.matricula = GeradorMatricula.gerarMatricula();
	}

	public int getMatricula() {
		return this.matricula;
	}

	public int getAnoIngresso() {
		return this.anoIngresso;
	}

	/*
	 * Atualiza o estado do aluno na universidade, conforme os estados disponíveis
	 * para ele a partir da classe Aluno.
	 */
	public void setEstado(int estado) {
		if (estado == Aluno.ATIVO || estado == Aluno.INATIVO || estado == Aluno.SUSPENSO) {
			this.estado = estado;
		} else {
			System.out.println("Estado do aluno inválido.");
		}
	}

	public int getEstado() {
		return this.estado;
	}

	/*
	 * Atualiza o código do curso de cada aluno, caso seja maior que zero.
	 */
	public void setCurso(int curso) {
		if (curso > 0) {
			this.curso = curso;
		} else {
			System.out.println("Curso inválido.");
		}
	}

	public int getCurso() {
		return this.curso;
	}

	/*
	 * Imprime todas as disciplinas que este aluno está cursando.
	 */
	public void imprimeDisciplinas() {
		if (this.disciplinas != null) {
			String result = "[";
			for (Disciplina disciplina : this.disciplinas) {
				result += disciplina.getId() + ", ";
			}
			result = result.substring(0, result.length() - 2);
			result += "]";
			System.out.print(result);
		}
	}

	/*
	 * Imprime os dados principais do aluno.
	 */
	public void imprimeDados() {
		super.imprimeDados();
		String saida = "Curso : " + this.curso + "\n";
		saida += "Estado : ";
		if (this.estado == Aluno.ATIVO) {
			saida += "ATIVO\n";
		} else if (this.estado == Aluno.INATIVO) {
			saida += "INATIVO\n";
		} else if (this.estado == Aluno.SUSPENSO) {
			saida += "SUSPENSO\n";
		}
		saida += "Matrícula : " + this.matricula + "\n";
		saida += "Ano de ingresso : " + this.anoIngresso + "\n";
		saida += "Ano limite para integralização : " + this.anoLimiteIntegralizacao;

		System.out.println(saida);
	}
}
