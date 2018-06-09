package lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeDisciplinas {

    private static List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    /*
      Adiciona uma disciplina na lista de disciplinas.
     */
    public static void addDisciplina(Disciplina disciplina){
        if (disciplina == null){
            System.out.println("Disciplina nula para adicionar no repositório");
        }
        else {
            if (RepositorioDeDisciplinas.disciplinas == null){
                RepositorioDeDisciplinas.disciplinas = new ArrayList<Disciplina>();
            }
            RepositorioDeDisciplinas.disciplinas.add(disciplina);
        }
    }


    /*
      Remove uma disciplina da lista de disciplinas.
     */
    public static void removeDisciplina(Disciplina disciplina){
        if (disciplina == null) {
            System.out.println("Disciplina nula para remover do repositório");
        }
        else{
            if (RepositorioDeDisciplinas.disciplinas == null || !RepositorioDeDisciplinas.disciplinas.remove(disciplina)){
                System.out.println("Essa disciplina não está no repositório para remover");
            }
        }
    }

    /*
      Busca uma disciplina na lista de disciplinas cujo nome foi passado como parâmetro.
     */
    public static Disciplina buscarDisciplina(String nome){
        List<Disciplina> disciplinasBuscadas = RepositorioDeDisciplinas.disciplinas.stream().filter(disciplina -> {
            return disciplina.getNome() != null && disciplina.getNome().equals(nome);
        }).collect(Collectors.toList());

        return (disciplinasBuscadas != null && !disciplinasBuscadas.isEmpty())?disciplinasBuscadas.get(0):null;
    }

    /*
      Busca uma disciplina na lista de disciplinas cujo id foi passado como parâmetro.
     */
    public static Disciplina buscarDisciplina(int id){
        List<Disciplina> disciplinasBuscadas = RepositorioDeDisciplinas.disciplinas.stream().filter(disciplina -> {
            return disciplina.getId() == id;
        }).collect(Collectors.toList());

        return (disciplinasBuscadas != null && !disciplinasBuscadas.isEmpty())?disciplinasBuscadas.get(0):null;
    }
}
