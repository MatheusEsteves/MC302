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
			  Iremos chamar o método imprimeDados de forma dinâmica, ou seja, será um
			  método diferente sobreposto para cada instância de PessoaFisica deste array.
			 */
			pessoa.imprimeDados();
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
