package rezende.israel.alura.dao;

import java.util.ArrayList;
import java.util.List;

import rezende.israel.alura.modelo.Aluno;

public class AlunoDAO {
    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
