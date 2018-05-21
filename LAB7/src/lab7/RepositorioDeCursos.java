package lab7;

import java.util.ArrayList;
import java.util.List;

/*
 Classe que representa um repositório onde todos os cursos instanciados no sistema são
 armazenados, com base em uma lista. Esse armazenamento ocorre de maneira estática.
 */
public class RepositorioDeCursos {

    private static List<Curso> cursos;

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
}
