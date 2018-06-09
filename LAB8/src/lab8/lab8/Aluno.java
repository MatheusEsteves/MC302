package lab8;

import java.util.ArrayList;
import java.util.List;

import mc302ef.GerenciadorAlunos;

/*
 * Representa um aluno com nome, cpf, matrícula, estado, curso, ano 
 * de ingresso na instituição e as disciplinas que cursa. Além disso
 * temo um campo chamado anoLimiteIntegralizacao que é configurado
 * a partir das subclasses de Alunos.
 */
public abstract class Aluno extends PessoaFisica {

	public static final int ATIVO = 1;
	public static final int INATIVO = 2;
	public static final int SUSPENSO = 3;

	private int matricula;
	private int estado;
	private int anoIngresso;
	protected List<Disciplina> disciplinas;

	protected List<Float> notasDisciplinas;
	/*
		Cada aluno só terá como ser matriculado em um curso, APENAS.
	 */
	private List<Curso> cursos;
	protected int somaCreditos;

	protected int anoLimiteIntegralizacao;

	public Aluno() {
		super();
		this.matricula = 0;
		this.estado = Aluno.INATIVO;
		this.anoIngresso = 0;
		this.disciplinas = new ArrayList<Disciplina>();
		this.cursos = new ArrayList<Curso>();
		this.notasDisciplinas = new ArrayList<Float>();
		this.somaCreditos = 0;
	}

	public Aluno(String nome, String cpf, int estado) {
		super(nome, cpf);
		this.setEstado(estado);
		this.gerarMatricula();
		this.somaCreditos = 0;
		this.disciplinas = new ArrayList<Disciplina>();
		this.notasDisciplinas = new ArrayList<Float>();
		this.cursos = new ArrayList<Curso>();
		/*
		 * Geramos aleatoriamente um ano de ingresso na instituição para o aluno.
		 */
		this.anoIngresso = GerenciadorAlunos.getAnoIngressoRandom();
	}

	/*
	  Método abstrato que poderá ser implementado pelas sub-classes de Aluno,
	  conforme as suas especificidades. Cada tipo de aluno possui seu critério
	  de aprovação específico, por exemplo aluno de graduação e aluno de pós graduação.
	 */
	public abstract boolean isAlunoAprovado(float nota);

	/*
	  Adiciona uma nota para esse aluno, de alguma disciplina
	 */
	public void addNotaDisciplina(float nota){
		if (nota < 0 || nota > 10){
			System.out.println("Nota inválida");
		}
		else{
			this.notasDisciplinas.add(new Float(nota));
		}
	}

	/*
	  Calcula a média das notas conforme as notas já cadastradas,
	  para um aluno normal de graduação
	 */
	public float getMediaNotasDisciplinas(){
		if (notasDisciplinas.isEmpty()){
			return 0;
		}
		float soma = 0;
		for (Float nota : notasDisciplinas){
			soma += nota.floatValue();
		}
		return soma / notasDisciplinas.size();
	}

	/*
		Verifica se o aluno em questão está ou não matriculado na disciplina passada como parâmetro.
		Ou seja, verifica se a disciplina passada como parâmetro está incluída na lista de
		disciplinas do aluno.
	*/
	public boolean isMatriculado(Disciplina disciplina){
		if (this.disciplinas == null){
			return false;
		}
		if (disciplina == null){
			return false;
		}
		return this.disciplinas.contains(disciplina);
	}

	public Curso getCurso(){
		return (this.cursos != null && !this.cursos.isEmpty())?this.cursos.get(0):null;
	}

	public boolean addCurso(Curso curso){
		if (curso == null){
			return false;
		}
		if (this.cursos == null) {
			this.cursos = new ArrayList<Curso>();
		}
		if (this.cursos.contains(curso)){
			return false;
		}
		return this.cursos.add(curso);
	}

	public boolean removeCurso(Curso curso){
		if (curso == null){
			return false;
		}
		if (this.cursos == null){
			return false;
		}
		return this.cursos.remove(curso);
	}

	public int getSomaCreditos(){
		return this.somaCreditos;
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
	@Override
	public void imprimeDados() {
		super.imprimeDados();
		String saida = "Estado : ";
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

	@Override
	public boolean equals(Object other){
		if (other == null) {
			return false;
		}
		Aluno aluno = (Aluno)other;
		if (this.getCpf().equals(aluno.getCpf())){
			return true;
		}
		return false;
	}
}
