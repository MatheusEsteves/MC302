package lab8;

public class MeuArrayOrdemLexicografica extends MeuArray{


    @Override
    public int comparaCustomizado(PessoaFisica p1, PessoaFisica p2) {
        return p1.getNome().compareTo(p2.getNome());
    }
}
