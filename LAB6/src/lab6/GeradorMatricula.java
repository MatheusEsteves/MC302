package lab6;

/*
 * Gera uma sequence para o número de matrícula, de maneira estática e 
 * sequencial em todo o sistema.
 */
public class GeradorMatricula {

	private static int matricula = 1;

	public static int gerarMatricula() {
		return GeradorMatricula.matricula++;
	}
}
