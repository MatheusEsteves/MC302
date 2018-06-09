package lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 Classe que representa um repositório onde todos os cursos instanciados no sistema são
 armazenados, com base em uma lista. Esse armazenamento ocorre de maneira estática.
 */
public class RepositorioDeCursos {

    private static List<Curso> cursos = new ArrayList<Curso>();

    /*
      Adiciona um curso na lista de cursos.
     */
    public static void addCurso(Curso curso){
        if (curso == null){
            System.out.println("Curso nulo para adicionar no repositório");
        }
        else {
            if (RepositorioDeCursos.cursos == null){
                RepositorioDeCursos.cursos = new ArrayList<Curso>();
            }
            RepositorioDeCursos.cursos.add(curso);
        }
    }


    /*
      Remove um curso da lista de cursos.
     */
    public static void removeCurso(Curso curso){
        if (curso == null) {
            System.out.println("Curso nulo para remover do repositório");
        }
        else{
            if (RepositorioDeCursos.cursos == null || !RepositorioDeCursos.cursos.remove(curso)){
                System.out.println("Esse curso não está no repositório para remover");
            }
        }
    }

    /*
      Busca um curso na lista de cursos cujo nome foi passado como parâmetro.
     */
    public static Curso buscarCurso(String nome){
        List<Curso> cursosBuscados = RepositorioDeCursos.cursos.stream().filter(curso -> {
            return curso.getNome() != null && curso.getNome().equals(nome);
        }).collect(Collectors.toList());

        return (cursosBuscados != null && !cursosBuscados.isEmpty())?cursosBuscados.get(0):null;
    }

    /*
      Busca um curso na lista de cursos cujo id foi passado como parâmetro.
     */
    public static Curso buscarCurso(int id){
        List<Curso> cursosBuscados = RepositorioDeCursos.cursos.stream().filter(curso -> {
            return curso.getId() == id;
        }).collect(Collectors.toList());

        return (cursosBuscados != null && !cursosBuscados.isEmpty())?cursosBuscados.get(0):null;
    }
}
