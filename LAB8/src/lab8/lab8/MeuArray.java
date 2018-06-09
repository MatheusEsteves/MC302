package lab8;

import java.util.ArrayList;
import java.util.Collections;

public abstract class MeuArray extends ArrayList<PessoaFisica> {

    /*
      Ordenamos todos os elementos da lista customizada MeuArray com
      base no critério de ordenação definido nas subclasses de MeuArray.
     */
	public void ordenar(){
        Collections.sort(this, (p1, p2) -> comparaCustomizado(p1,p2));
	}

	/*
	  Método abstrato (cuja obrigatoriedade de implementação é da subclasse de MeuArray).
	  Definimos um critério de ordenação no qual 2 entidades são comparadas entre si
	  conforme o critério estabelecido.
	 */
	public abstract int comparaCustomizado(PessoaFisica p1, PessoaFisica p2);

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
}
