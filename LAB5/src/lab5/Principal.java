package lab5;

import java.util.ArrayList;

import mc302ef.GerenciadorAlunos;
import mc302ef.GerenciadorDisciplinas;

/*
 * Nome: Matheus Esteves Zanoto  RA: 184256
 * 
 * Objetivos: Treinar os conceitos de herança, encapsulamento, boas práticas de Programação
 * Orientada a Objetos e praticar o relacionamento bidirecional entre 2 entidades. Importamos
 * vários alunos e instanciamos objetos desses alunos conforme o seu tipo (graduação, mestrando 
 * ou doutorando), utilizando o conceito de herança : todos herdam de Aluno. Imprimimos cada
 * uma das entidades de maneira diferente conforme o tipo de Aluno. A segunda parte consiste
 * em praticar o relacionamento bidirecional através das entidades Aluno e Disciplina. Um 
 * aluno poderá estar matriculado em várias disciplina e uma disciplina poderá ter vários alunos
 * matriculados. Dessa maneira, um aluno poderá visualizar as suas disciplinas e o administrador
 * de uma disciplina poderá ter acesso aos alunos matriculados nessa disciplina.
 * 
 * Entradas: Na primeira parte, recebemos uma lista ArrayList<String[]> na importação onde estão armazenados
 * os dados dos alunos. Cada posição dessa lista corresponde a um aluno e cada posição do array contido em 
 * cada posição da lista corresponde a um atributo desse aluno. Na segunda parte recebemos uma lista
 * ArrayList<String[]> onde estão armazenados os dados das disciplinas e dos alunos associados, identificados
 * através do CPF. Cada posição da lista representa uma associação entre um aluno e suas disciplinas.
 * 
 * Saídas: Na primeira parte, printamos os dados dos alunos conforme o tipo de aluno (graduação, mestrando
 * ou doutorando). Na segunda parte, printamos os alunos matriculados em cada disciplina e as disciplinas
 * que cada aluno cursa, de modo a visualizar o relacionamento bidirecional.
 */
public class Principal {

	public static void testaInclusaoAlunos() {
		System.out.println("LEITURA DE ALUNOS");
		System.out.println("=========================================");
		System.out.println();

		/*
		 * Leitura de informação de alunos e suas instanciações.
		 */
		ArrayList<String[]> infoAlunos = GerenciadorAlunos.getListaAlunos();
		String vinculo, nome, cpf;
		int curso;

		for (String[] campo : infoAlunos) {
			/*
			 * Utilizamos vinculo para definir qual instancia de Aluno devemos trabalhar.
			 * Utilizamos os atributos padrões de um aluno na instanciação das sub-classes
			 * de aluno.
			 */
			vinculo = campo[GerenciadorAlunos.I_VINCULO];
			nome = campo[GerenciadorAlunos.I_NOME];
			cpf = campo[GerenciadorAlunos.I_CPF];
			curso = Integer.parseInt(campo[GerenciadorAlunos.I_CURSO]);

			if (vinculo.equalsIgnoreCase(GerenciadorAlunos.GRADUACAO)) {
				AlunoGraduacao alunoGraduacao = new AlunoGraduacao(nome, cpf, Aluno.ATIVO, curso);
				alunoGraduacao.imprimeDados();
			} else {
				/*
				 * Caso o aluno for da pós graduação, capturamos os atributos padrões de um
				 * aluno da pós graduação,referentes à sua qualificação no exame e à aprovação
				 * do inglês, que são setados especificamente e de maneira diferente conforme a
				 * sub-classe de AlunoPos
				 */
				boolean isQualificado = Boolean.parseBoolean(campo[GerenciadorAlunos.I_QUALIFICADO]);
				boolean isInglesAprovado = Boolean.parseBoolean(campo[GerenciadorAlunos.I_INGLES_APROVADO]);

				if (vinculo.equalsIgnoreCase(GerenciadorAlunos.MESTRADO)) {
					AlunoMestrado alunoMestrado = new AlunoMestrado(nome, cpf, Aluno.ATIVO, curso, isInglesAprovado,
							isQualificado);
					alunoMestrado.imprimeDados();
				} else if (vinculo.equalsIgnoreCase(GerenciadorAlunos.DOUTORADO)) {
					AlunoDoutorado alunoDoutorado = new AlunoDoutorado(nome, cpf, Aluno.ATIVO, curso, isInglesAprovado,
							isQualificado);
					alunoDoutorado.imprimeDados();
				}
			}
			System.out.println();
		}
	}

	/*
	 * Utilizamos o método estático getDisciplinas para obter os dados completos de
	 * todas as disciplinas em uma matriz (dados obtidos via importação). EM
	 * seguida, instanciamos um objeto Disciplina com base no id passado como
	 * parâmetro e na lista de disciplinas disponíveis, obtendo outros dados como o
	 * seu nome.
	 */
	private static Disciplina getDisciplinaPorId(int id) {
		String[][] disciplinasInfo = GerenciadorDisciplinas.getDisciplinas();

		for (String[] disciplinaInfo : disciplinasInfo) {
			int discId = Integer.parseInt(disciplinaInfo[GerenciadorDisciplinas.ID]);
			if (discId == id) {
				String discNome = disciplinaInfo[GerenciadorDisciplinas.NOME];
				return new Disciplina(discId, discNome);
			}
		}
		return null;
	}

	public static void testaInscricaoEmDisciplinas() {
		System.out.println();
		System.out.println("INSCRIÇÃO EM DISCIPLINAS");
		System.out.println("=========================================");
		System.out.println();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		ArrayList<String[]> infoAlunos = GerenciadorAlunos.getDisciplinasPorCpfAluno();

		String cpfAluno;
		int idDisciplina;

		/*
		 * Obtemos todos os alunos retornados via importação e instanciamos um Aluno
		 * para cada CPF retornado (maneira pela qual identificamos um aluno).
		 */
		for (String[] params : infoAlunos) {
			cpfAluno = params[0];
			Aluno aluno = new Aluno("ALUNO TESTE", cpfAluno, Aluno.ATIVO, 1);
			alunos.add(aluno);
			for (int i = 1; i < params.length; i++) {
				/*
				 * Para cada um dos alunos retornados, adicionamos cada uma das disciplinas
				 * associadas à essa aluno (obtido na mesma posição da lista infoAlunos) na
				 * lista de alunos relacionados à disciplina considerada (consequentemente essa
				 * disciplina será adicionada na lista de disciplinas do aluno considerado, via
				 * implementação interna do método de inserção).
				 */
				idDisciplina = Integer.parseInt(params[i]);
				Disciplina disciplina = Principal.getDisciplinaPorId(idDisciplina);
				if (disciplina != null) {
					if (disciplinas.contains(disciplina)) {
						disciplinas.get(disciplinas.indexOf(disciplina)).addAluno(aluno);
					} else {
						disciplina.addAluno(aluno);
						disciplinas.add(disciplina);
					}
				}
			}
		}
		for (Disciplina disciplina : disciplinas) {
			disciplina.imprimeDados();
			System.out.println();
		}
		System.out.println("SITUAÇÃO DOS ALUNOS NAS DISCIPLINAS");
		System.out.println("=========================================");
		System.out.println();
		for (Aluno aluno : alunos) {
			System.out.println("Aluno : " + aluno.getCpf());
			System.out.print("Disciplinas : ");
			aluno.imprimeDisciplinas();
			System.out.println();
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Principal.testaInclusaoAlunos();
		Principal.testaInscricaoEmDisciplinas();
	}
}
