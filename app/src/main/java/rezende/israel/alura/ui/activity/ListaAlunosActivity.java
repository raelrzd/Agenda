package rezende.israel.alura.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rezende.israel.alura.R;
import rezende.israel.alura.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // BALÃO INFERIOR AO ABRIR O APP
        Toast.makeText(this, "Seja bem vindo!!", Toast.LENGTH_LONG).show();
        // APRESENTA ARQUIVO DE ACTIVITY
        setContentView(R.layout.lista_alunos_activity);
        setTitle("Lista De Alunos");


        FloatingActionButton botaoAdicionar = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        AlunoDAO dao = new AlunoDAO();
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dao.todos()));
    }
}
