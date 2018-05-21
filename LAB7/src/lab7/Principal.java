package lab7;

/*
 * Nome: Matheus Esteves Zanoto  RA: 184256
 *
 * Objetivos: esse laboratório possui como objetivo principal treinar o conceito de classe interna,
 * através de um gerenciamento de solicitações de matrícula de uma determinada universidade, na qual
 * matriculamos um aluno numa disciplina em sequência, caso o número de créditos disponíveis para
 * o aluno permita.
 *
 * Entradas: não recebemos entrada, porém instanciamos várias disciplinas e alunos para verificarmos o
 * processo de matrícula de cada um desses alunos nas disciplinas consideradas. Além disso, instanciamos
 * um curso para teste.
 *
 * Saídas: como saída, exibimos os dados do aluno matriculado no curso em questão, bem como todas
 * as disciplinas nas quais o aluno foi matriculado. Processamos todas as solicitações de matrícula
 * dos alunos e verificamos os alunos matriculados na disciplina em questão.
 *
 */
public class Principal {

	public static void main(String args[]) {
		/*
		  Criamos um aluno e matriculamos ele no curso Ciência da Computação.
		 */
		Curso curso = new Curso("Ciência da Computação", 6);
		Aluno aluno = new Aluno("Matheus Esteves Zanoto", "87065455874", Aluno.ATIVO);
		curso.matricularAluno(aluno);

		/*
		 Criamos 4 disciplinas para solicitarmos matrícula do aluno criado anteriormente. Solicitamos a
		 matricula desse aluno nessas disciplinas, as quais serão processadas posteriormente.
		 */
		Disciplina disciplinaCalculoIII = new Disciplina(100, "Cálculo III", 1, 10);
		Disciplina disciplinaAlgebraLinear = new Disciplina(200, "Álgebra Linear", 2, 10);
		Disciplina disciplinaCalculoI  = new Disciplina(330, "Cálculo I", 3, 10);
		Disciplina disciplinaCalculoII = new Disciplina(400, "Cálculo II", 2, 10);

		ControladorDeMatricula controladorMatricula = new ControladorDeMatricula();
		controladorMatricula.solicitarMatricula(disciplinaCalculoI, aluno);
		controladorMatricula.solicitarMatricula(disciplinaCalculoII, aluno);
		controladorMatricula.solicitarMatricula(disciplinaCalculoIII, aluno);
		controladorMatricula.solicitarMatricula(disciplinaAlgebraLinear, aluno);

		/*
			Processamos de fato todas as solicitações de matricula feitas anteriormente. Porém como o limite
			de créditos para o curso ciência da computação é 6 , processamos apenas 3 disciplinas, pois
			com a quarta, esse limite de créditos é ultrapassado para o aluno criado.
		 */
		controladorMatricula.processarSolicitacoesMatricula();
		System.out.println("DADOS DO ALUNO");
		aluno.imprimeDados();
		System.out.println();
		System.out.println("DISCIPLINAS EM QUE O ALUNO FOI MATRICULADO");
		aluno.imprimeDisciplinas();
		System.out.println();

		/*
		  Limpamos todas as solicitações feitas até o momento, depois de processadas, com o objetivo de
		  criar novas solicitações posteriormente.
		 */
		controladorMatricula.refazerSolicitacoesMatricula();

		/*
		  Criamos uma disciplina cujo limite de alunos é 25 e tentamos matricular 26 alunos nessa disciplina.
		  Como resultado, os 25 primeiros alunos são matriculados, apenas.
		 */
        Disciplina disciplinaCalculoNumerico  = new Disciplina(330, "Cálculo Numérico", 3, 25);
        for (int i = 1; i <= 26; i++) {
            String cpf = (i < 10)?"4706545587"+i:"470654558"+i;
            Aluno alunoDisciplina = new Aluno("ALUNO " + i, cpf, Aluno.ATIVO);
            curso.matricularAluno(alunoDisciplina);
            controladorMatricula.solicitarMatricula(disciplinaCalculoNumerico, alunoDisciplina);
        }
        controladorMatricula.processarSolicitacoesMatricula();
        System.out.println();
        System.out.println("DADOS DA DISCIPLINA COM NÚMERO MÁXIMO DE 25 ALUNOS");
        disciplinaCalculoNumerico.imprimeDados();
	}
}
