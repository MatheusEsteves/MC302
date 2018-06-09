package lab8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Classe que representa uma Disciplina na universidade, a qual contém um código identificador,
 * um nome e os alunos matriculados nessa disciplina.
 */
public abstract class Disciplina {

	public final int MAX_ALUNOS;
	private static final int NOME_MIN_LEN = 4;

	private final int ID;
	private String nome;
	protected List<Aluno> alunos;
	private List<SituacaoAprovacao> aprovacoesAlunos;
	private List<Float> notasAlunos;
	private int creditos;

	public Disciplina(int id, String nome, int  creditos, int maxAlunos) {
		this.ID = id;
		this.setNome(nome);
		this.setCreditos(creditos);
		this.MAX_ALUNOS = maxAlunos;
		this.alunos = new ArrayList<Aluno>();
		this.notasAlunos = new ArrayList<Float>();
		this.aprovacoesAlunos = new ArrayList<SituacaoAprovacao>();
	}

	/*
	  Método para atribuir notas para todos os alunos matriculados nessa disciplina e
	  verificar se o aluno foi aprovado ou não, conforme a nota atribuiída e o seu
	  critério de aprovado (definido a partir de cada instância específica da classe Aluno).
	 */
	public void atribuirNotas(){
		for (Aluno aluno : alunos){
			float nota = GeradorNota.getNota();
			notasAlunos.add(new Float(nota));
			SituacaoAprovacao situacaoAprovacao = (aluno.isAlunoAprovado(nota))?
					SituacaoAprovacao.APROVADO:SituacaoAprovacao.REPROVADO;
			aprovacoesAlunos.add(situacaoAprovacao);
		}
	}


	public void setCreditos(int creditos){
		if (creditos <= 0){
			System.out.println("Número de créditos inválido.");
		}
		else{
			this.creditos = creditos;
		}
	}

	public int getCreditos(){
		return this.creditos;
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
			Iterator<Aluno> iteratorAlunos = alunos.iterator();
			Iterator<Float> iteratorNotas = notasAlunos.iterator();
			Iterator<SituacaoAprovacao> iteratorAprovacoes = aprovacoesAlunos.iterator();
			while (iteratorAlunos.hasNext()){
				Aluno aluno = iteratorAlunos.next();
				Float nota = iteratorNotas.next();
				SituacaoAprovacao situacao = iteratorAprovacoes.next();

				String cpf = aluno.getCpf();
				if (i == 0) {
					resp += "[" + cpf;
				} else {
					resp += ", " + cpf;
				}
				resp += "(Nota: " + nota.floatValue() + " - "  + situacao.toString()+")";
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
