package rezende.israel.alura.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import rezende.israel.alura.R;
import rezende.israel.alura.dao.AlunoDAO;
import rezende.israel.alura.modelo.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Novo Aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TITULO_APPBAR);
        setContentView(R.layout.activity_formulario_aluno);

        inicializacaoDosCampos();

        configuraBotaoSalvar();

    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_alunos_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criaAluno();
                salvaAluno(alunoCriado);
            }
        });
    }

    private void salvaAluno(Aluno alunoCriado) {
        dao.salva(alunoCriado);
        finish();
    }

    @NonNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        Aluno alunoCriado = new Aluno(nome, telefone, email);
        Toast.makeText(FormularioAlunoActivity.this, "Registro de Aluno Salvo!", Toast.LENGTH_SHORT).show();
        return alunoCriado;
    }

    private void inicializacaoDosCampos() {
        campoNome = findViewById(R.id.activity_formulario_alunos_nome);
        campoTelefone = findViewById(R.id.activity_formulario_alunos_telefone);
        campoEmail = findViewById(R.id.activity_formulario_alunos_email);
    }
}
