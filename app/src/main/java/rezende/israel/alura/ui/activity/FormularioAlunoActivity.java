package rezende.israel.alura.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import rezende.israel.alura.R;
import rezende.israel.alura.modelo.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Novo Aluno");

    setContentView(R.layout.activity_formulario_aluno);
    final EditText campoNome = findViewById(R.id.activity_formulario_alunos_nome);
    final EditText campoTelefone = findViewById(R.id.activity_formulario_alunos_telefone);
    final EditText campoEmail = findViewById(R.id.activity_formulario_alunos_email);

    Button botaoSalvar = findViewById(R.id.activity_formulario_alunos_botao_salvar);
    botaoSalvar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nome = campoNome.getText().toString();
            String telefone = campoTelefone.getText().toString();
            String email = campoEmail.getText().toString();

            Aluno alunoCriado = new Aluno(nome, telefone, email);
            Toast.makeText(FormularioAlunoActivity.this,
                    alunoCriado.getNome() + " - " + alunoCriado.getTelefone() + " - " + alunoCriado.getEmail(),
                    Toast.LENGTH_LONG).show();

        }
    });

    }
}
