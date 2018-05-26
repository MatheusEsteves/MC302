package lab7;

/*
 * Nome: Matheus Esteves Zanoto  RA: 184256
 *
 * Objetivos: esse laboratório possui como objetivo principal treinar o conceito de polimorfismo
 * em POO, através da sobreposição de métodos para alunos, professores e construtores no geral.
 * Criamos repositórios para as entidades com métodos polimórficos de busca, alteramos os alunos
 * de pós graduação para que possam ter orientadores e acrescentamos um método para retornar
 * a média das notas desses alunos.
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
		Aluno alunoGraduacao = new Aluno("Matheus","11111111111",Aluno.ATIVO);
		Aluno alunoMestrado = new AlunoMestrado("Gabriel","22222222222",Aluno.ATIVO, true, true);
		Aluno alunoDoutorado = new AlunoDoutorado(
				"Vinicius", "33333333333", Aluno.ATIVO,
				true, true);

		MeuArray meuArray = new MeuArray();
		meuArray.add(alunoGraduacao);
		meuArray.add(alunoMestrado);
		meuArray.add(alunoDoutorado);

		alunoGraduacao.addNotaDisciplina((float)8);
		alunoGraduacao.addNotaDisciplina((float)8.5);
		alunoMestrado.addNotaDisciplina((float)8);
		alunoMestrado.addNotaDisciplina((float)8.5);

		System.out.println("==================================");
		System.out.println("MÉDIA DAS NOTAS PARA O ALUNO DE GRADUAÇÃO : " + alunoGraduacao.getMediaNotasDisciplinas());
		System.out.println("MÉDIA DAS NOTAS PARA O ALUNO DE MESTRADO : " + alunoMestrado.getMediaNotasDisciplinas());
		System.out.println("==================================");
		System.out.println("TESTANDO SOBREPOSIÇÃO DE MÉTODOS");
		System.out.println("==================================");
		meuArray.imprimirPessoas();
	}
}
