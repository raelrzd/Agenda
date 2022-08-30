package rezende.israel.alura;

import android.app.Application;
import android.widget.Toast;

import rezende.israel.alura.dao.AlunoDAO;
import rezende.israel.alura.modelo.Aluno;

public class AgendaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Rael", "14997225375", "rael@gmail.com"));
        dao.salva(new Aluno("Gui", "1111111111", "gui@gmail.com"));
        // BALÃO INFERIOR AO ABRIR O APP
        Toast.makeText(this, "Seja bem vindo!!", Toast.LENGTH_LONG).show();
    }
}
