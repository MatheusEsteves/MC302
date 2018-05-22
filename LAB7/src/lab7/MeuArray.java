package lab7;

import java.util.ArrayList;
import java.util.Arrays;

public class MeuArray extends ArrayList<PessoaFisica> {

	public void ordenarPorNome() {
		ArrayList<PessoaFisica> aux = new ArrayList<PessoaFisica>();
		/*
		 * Enquanto não houver mais nenhum elemento na lista de pessoas, removemos o
		 * menor elemento (comparando o nome) e inserimos ele em uma lista auxiliar.
		 * Dessa maneira, lista auxiliar está, no final, ordenada por nome.
		 */
		while (!this.isEmpty()) {
			aux.add(this.removerMenor());
		}
		/*
		 * Passamos a lista auxiliar na lista original, mantendo ela ordenada.
		 */
		this.addAll(aux);
		aux.removeAll(aux);
	}

	public void imprimirPessoas() {
		for (PessoaFisica pessoa : this) {
			/*
			 * Como qualquer elemento da lista sempre será uma pessoa física,
			 * independentemente do tipo da pessoa, sempre exibiremos o nome e o CPF como
			 * padrão.
			 */
			System.out.println("PESSOA FÍSICA : " + pessoa.getNome() + " , CPF : " + pessoa.getCpf());

			if (pessoa instanceof Aluno) {
				/*
				 * Se o tipo da pessoa for uma aluno, então exibiremos a sua matrícula.
				 */
				System.out.println("Classificação : ALUNO");
				Aluno aluno = (Aluno) pessoa;
				System.out.println("Matrícula : " + aluno.getMatricula());
			} else {
				if (pessoa instanceof Funcionario) {
					/*
					 * Se o tipo da pessoa for um funcionário, exibiremos por padrão o seu salário,
					 * indepedentemente do tipo de funcionário que estamos tratando.
					 */
					System.out.println("Classificação : FUNCIONÁRIO");
					Funcionario funcionario = (Funcionario) pessoa;
					System.out.println("Salário : " + funcionario.getSalario());

					if (funcionario instanceof Professor) {
						/*
						 * Se o tipo do funcionário for um professor, exibiremos as disciplinas que
						 * leciona.
						 */
						System.out.println("Função do funcionário : PROFESSOR");
						Professor professor = (Professor) funcionario;
						System.out.println("Disciplinas : " + Arrays.toString(professor.getDisciplinas()));
					} else {
						if (funcionario instanceof Seguranca) {
							/*
							 * Se o tipo de funcionário for um segurança. exibiremos o período do plantão
							 * que ele trabalha.
							 */
							System.out.println("Função do funcionário : SEGURANÇA");
							Seguranca seguranca = (Seguranca) funcionario;
							System.out.println("Período do plantão : " + seguranca.getPeriodoPlantao());
						}
					}
				}
			}
			System.out.println("==========================================================================");
		}
	}

	/*
	 * Encontramos o menor elemento na lista de pessoas desta classe, com base nos
	 * elementos ainda existentes na lista, comparando o nome.
	 */
	private PessoaFisica removerMenor() {
		PessoaFisica menorEncontrado = this.get(0);
		for (PessoaFisica pessoa : this) {
			if (pessoa.getNome().compareTo(menorEncontrado.getNome()) < 0) {
				menorEncontrado = pessoa;
			}
		}
		this.remove(menorEncontrado);
		return menorEncontrado;
	}
}
