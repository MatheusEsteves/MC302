package lab7;

import java.util.ArrayList;
import java.util.List;

/*
 * Representa um aluno genérico da pós graduação, que poderá possuir
 * várias sub-divisões conforme o tipo de pós-graduando.
 */
public class AlunoPos extends Aluno {

	protected boolean isInglesComprovado;
	protected boolean isExameQualificacaoAprovado;

	private Professor orientador;

	/*
	  Construtor para caso o aluno de pós graduação NÃO possua algum orientador
	  previamente cadastrado.
	 */
	public AlunoPos(String nome, String cpf, int estado) {
		super(nome, cpf, estado);
	}

	/*
	  Construtor para caso o aluno de pós graduação já possua algum orientador
	  previamente cadastrado.
	 */
	public AlunoPos(String nome, String cpf, int estado, Professor orientador) {
		this(nome, cpf, estado);
		this.orientador = orientador;
	}

	/*
	 * Imprime os dados principais de um aluno da pós graduação.
	 */
	@Override
	public void imprimeDados() {
		super.imprimeDados();
	}

	/*
	  Estrutura que representa a nota decimal de um aluno para uma letra, que
	  consiste na nota de um aluno de pós graduação. Cada letra possui um
	  valor associado de 1 até 4.
	 */
	private enum NotaPos{
		A(4),B(3),C(2),D(1);

		private int value;

		NotaPos(int value){
			this.value = value;
		}

		public int getValue(){
			return this.value;
		}
	}

	/*
	  Converte uma determinada nota em decimal para seu correspondente em letra,
	  a fim de calcular a média.
	 */
	private NotaPos converterNotaDecimalParaNotaPos(float notaDecimal){
		if (notaDecimal >= 8.5){
			return NotaPos.A;
		}
		if (notaDecimal >= 7){
			return NotaPos.B;
		}
		if (notaDecimal >= 5){
			return NotaPos.C;
		}
		return NotaPos.D;
	}

	/*
	  Calcula a média com base nas notas transformadas ([A,B,C,D])
	  e seus valores associados.
	 */
	private float getMediaPos(List<NotaPos> notasPos){
		if (notasPos.isEmpty()){
			return 0;
		}
		float soma = 0;
		for (NotaPos notaPos : notasPos){
			soma += notaPos.getValue();
		}
		return soma / notasPos.size();
	}

	/*
	  Calcula a média das notas conforme as notas já cadastradas,
	  de modo específico para um aluno de pós graduação, seguindo
	  o padrão [A,B,C,D]
	 */
	@Override
	public float getMediaNotasDisciplinas(){
		if (notasDisciplinas.isEmpty()){
			return 0;
		}
		/*
		  Convertemos todas as notas de [0,10] cadastradas para a escala [A,B,C,D] conforme
		  o critério estabelecido abaixo para alunos de pós graduação
		 */
		List<NotaPos> notasPos = new ArrayList<NotaPos>();
		for (Float notaDecimal : notasDisciplinas){
			notasPos.add(converterNotaDecimalParaNotaPos(notaDecimal.floatValue()));
		}
		return getMediaPos(notasPos);
	}
}
