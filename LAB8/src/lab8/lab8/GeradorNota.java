package lab8;

import java.text.DecimalFormat;
import java.util.Random;

/*
 Classe com um método estático para gerar uma nota de forma aleatória
 (variando no intervalo de 0 até 10) para os alunos.
 */
public class GeradorNota {

    private static final Random random = new Random();

    public static float getNota(){
        float notaValue = GeradorNota.random.nextFloat() * 10;
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        notaValue = Float.parseFloat(decimalFormat.format(notaValue));
        return notaValue;
    }
}
