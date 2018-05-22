package lab7;

import javax.naming.ldap.Control;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorAluno {

    private static List<Aluno> alunos = new ArrayList<Aluno>();

    public static void addAluno(Aluno aluno)throws Exception{
        if (aluno == null){
            throw new Exception("Aluno nulo ao tentar adicionar aluno no controlador");
        }
        if (ControladorAluno.alunos == null){
            ControladorAluno.alunos = new ArrayList<Aluno>();
        }
        ControladorAluno.alunos.add(aluno);
    }

    public static boolean removeAluno(Aluno aluno) throws Exception{
        if (aluno == null){
            throw new Exception("Aluno nulo ao tentar remover do controlador");
        }
        if (ControladorAluno.alunos == null){
            return false;
        }
        return ControladorAluno.alunos.remove(aluno);
    }

    public static Aluno buscarAlunos(int matricula){
        List<Aluno> alunosBuscados = ControladorAluno.alunos.stream().filter(aluno -> {
            return aluno.getMatricula() == matricula;}).collect(Collectors.toList());

        return (alunosBuscados != null && !alunosBuscados.isEmpty())?alunosBuscados.get(0):null;
    }

    public static Aluno buscarAlunos(String cpf){
        List<Aluno> alunosBuscados = ControladorAluno.alunos.stream().filter(aluno -> {
            return aluno.getCpf().equals(cpf);
        }).collect(Collectors.toList());

        return (alunosBuscados != null && !alunosBuscados.isEmpty())?alunosBuscados.get(0):null;
    }

    public static Aluno buscarAlunos(String cpf, Curso curso){
        List<Aluno> alunosBuscados = ControladorAluno.alunos.stream().filter(aluno -> {
           return aluno.getCpf().equals(cpf) &&
                   aluno.getCurso() != null &&
                   aluno.getCurso().equals(curso);
        }).collect(Collectors.toList());

        return (alunosBuscados != null && !alunosBuscados.isEmpty())?alunosBuscados.get(0):null;
    }

    public static List<Aluno> buscarAlunos(String nome, Disciplina disciplina){
        return ControladorAluno.alunos.stream().filter(aluno -> {
            return nome != null &&
                    aluno.getNome() != null &&
                    aluno.getNome().contains(nome) &&
                    aluno.isMatriculado(disciplina);

        }).collect(Collectors.toList());
    }
}
