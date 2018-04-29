package lab5;

import java.util.ArrayList;
import java.util.List;

/*
 * Classe que representa uma Disciplina na universidade, a qual contém um código identificador,
 * um nome e os alunos matriculados nessa disciplina.
 */
public class Disciplina {

	public static final int MAX_ALUNOS = 25;
	private static final int NOME_MIN_LEN = 4;

	private final int ID;
	private String nome;
	private List<Aluno> alunos;

	public Disciplina(int id, String nome) {
		this.ID = id;
		this.nome = nome;
		this.alunos = new ArrayList<Aluno>();
	}

	public String getNome() {
		return this.nome;
	}

	public int getId() {
		return this.ID;
	}

	public void setNome(String nome) {
		if (nome.length() >= Disciplina.NOME_MIN_LEN) {
			this.nome = nome;
		} else {
			System.out.println("O nome informado possui menos de " + Disciplina.NOME_MIN_LEN + " caracteres.");
		}
	}

	/*
	 * Adicionamos um novo aluno matriculado na disciplina, caso esse aluno já não
	 * esteja matriculado nessa disciplina. Em seguida, adicionamos essa disciplina
	 * a lista de disciplinas do aluno incluido, com o objetivo de mantermos o
	 * relacionamento bidirecional entre as duas entidades.
	 */
	public boolean addAluno(Aluno aluno) {
		if (aluno == null) {
			return false;
		}
		if (this.alunos == null) {
			this.alunos = new ArrayList<Aluno>();
		}
		if (this.alunos.contains(aluno)) {
			return false;
		}
		return this.alunos.add(aluno) && aluno.addDisciplina(this);
	}

	/*
	 * Removemos o aluno matriculado da lista de alunos dessa disciplina. Em
	 * seguida, removemos essa disciplina da lista de disciplinas do aluno incluido,
	 * com o objetivo de mantermos o relacionamento bidirecional entre as duas
	 * entidades.
	 */
	public boolean removeAluno(Aluno aluno) {
		if (aluno != null && this.alunos != null) {
			return this.alunos.remove(aluno) && aluno.removeDisciplina(this);
		}
		return false;
	}

	/*
	 * Imprimimos os dados principais da disciplina : seu nome, id e os alunos
	 * matriculados na mesma.
	 */
	public void imprimeDados() {
		String resp = this.nome + "(" + this.ID + ")\n";
		int i = 0;

		if (this.alunos != null) {
			for (Aluno aluno : this.alunos) {
				String cpf = aluno.getCpf();
				if (i == 0) {
					resp += "[" + cpf;
				} else {
					resp += ", " + cpf;
				}
				i++;
			}
		}
		resp += "]";

		System.out.println(resp);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other instanceof Disciplina) {
			Disciplina disciplina = (Disciplina) other;
			return this.ID == disciplina.getId();
		}
		return false;
	}
}
