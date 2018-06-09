package lab8;

/*
 * Nome: Matheus Esteves Zanoto  RA: 184256
 *
 * Objetivos: esse laboratório possui como objetivo principal treinar o conceito de classe abstrata e
 * método abstrato em POO, através da sobreposição de métodos para alunos, professores e construtores no geral.
 * Alteramos os alunos para que possam ter seu critério de aprovação específico conforme o tipo desse aluno.
 *
 * Entradas: não recebemos entrada, porém instanciamos várias disciplinas e alunos para verificarmos
 * se os métodos polimórficos estão sendo realizados corretamente.
 *
 * Saídas: como saída, exibimos o retorno do método imprimeDados() diferenciado conforme cada
 * instância de PessoaFisica e exibimos o retorno dos outros métodos polimórficos.
 *
 */
public class Principal {

	public static void main(String args[]){
		AlunoGraduacao alunoGraduacao = new AlunoGraduacao("Matheus","11111111111",Aluno.ATIVO);
		AlunoMestrado alunoMestrado = new AlunoMestrado("Gabriel","22222222222",Aluno.ATIVO, true, true);
		AlunoDoutorado alunoDoutorado = new AlunoDoutorado(
				"Vinicius", "33333333333", Aluno.ATIVO,
				true, true);

		MeuArrayOrdemLexicografica meuArray = new MeuArrayOrdemLexicografica();
		meuArray.add(alunoGraduacao);
		meuArray.add(alunoMestrado);
		meuArray.add(alunoDoutorado);

		DisciplinaPos disciplinaPos1 = new DisciplinaPos(
				SequenceBuilder.nextSequence(), "Disciplina Pós 1", 30, 50
		);
		DisciplinaPos disciplinaPos2 = new DisciplinaPos(
				SequenceBuilder.nextSequence(), "Disciplina Pós 2", 40, 60
		);

		DisciplinaGraduacao disciplinaGraduacao = new DisciplinaGraduacao(
			SequenceBuilder.nextSequence(), "Cálculo II", 50, 40
		);

		disciplinaGraduacao.addAluno(alunoGraduacao);

		alunoGraduacao.addNotaDisciplina((float)8);
		alunoGraduacao.addNotaDisciplina((float)8.5);
		disciplinaPos1.addAluno(alunoGraduacao);

		alunoMestrado.addNotaDisciplina((float)8);
		alunoMestrado.addNotaDisciplina((float)8.5);
		disciplinaPos2.addAluno(alunoMestrado);
		disciplinaPos2.addAluno(alunoGraduacao);
		disciplinaPos2.addAluno(alunoDoutorado);

		disciplinaPos1.atribuirNotas();
		disciplinaPos2.atribuirNotas();
		disciplinaGraduacao.atribuirNotas();

		System.out.println("DADOS DAS DICIPLINAS");
		System.out.println("==================================");
		disciplinaPos1.imprimeDados();
		System.out.print("\n");
		disciplinaPos2.imprimeDados();
		System.out.print("\n");
		disciplinaGraduacao.imprimeDados();

		System.out.println("==================================");
		System.out.println("MÉDIA DAS NOTAS PARA O ALUNO DE GRADUAÇÃO : " + alunoGraduacao.getMediaNotasDisciplinas());
		System.out.println("MÉDIA DAS NOTAS PARA O ALUNO DE MESTRADO : " + alunoMestrado.getMediaNotasDisciplinas());
		System.out.println("==================================");
		System.out.println("TESTANDO SOBREPOSIÇÃO DE MÉTODOS");
		System.out.println("==================================");

		meuArray.ordenar();
		meuArray.imprimirPessoas();
	}
}
