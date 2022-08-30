package rezende.israel.alura.ui.activity;

import static rezende.israel.alura.ui.activity.ConstantesActivities.CHAVE_ALUNO;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import rezende.israel.alura.R;
import rezende.israel.alura.dao.AlunoDAO;
import rezende.israel.alura.modelo.Aluno;
import rezende.israel.alura.ui.ListaAlunosView;
import rezende.israel.alura.ui.adapter.ListaAlunosAdapter;

@SuppressWarnings("ALL")
public class ListaAlunosActivity extends AppCompatActivity {
    public static final String TITULO_APPBAR = "Lista De Alunos";
    private final AlunoDAO dao = new AlunoDAO();
    private ListaAlunosAdapter adapter;
    private final ListaAlunosView listaAlunosView = new ListaAlunosView(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // CHAMA ARQUIVO DE LAYOUT DA ACTIVITY
        setContentView(R.layout.lista_alunos_activity);
        setTitle(TITULO_APPBAR);
        configuraFabNovoAluno();
        configuraLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_alunos_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_alunos_menu_remover) {
            listaAlunosView.confirmaRemocao(item);
        }
        return super.onContextItemSelected(item);
    }


    private void configuraFabNovoAluno() {
        FloatingActionButton botaoAdicionar = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoAdicionar.setOnClickListener(view -> abreFormularioModoInsereAluno());
    }

    private void abreFormularioModoInsereAluno() {
        startActivity(new Intent(this, FormularioAlunoActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaAlunosView.atualizaAlunos();
    }


    private void configuraLista() {
        ListView listaDeAlunos = findViewById(R.id.activity_lista_de_alunos_listview);
        listaAlunosView.configuraAdapter(listaDeAlunos);
        configuraListenerDeCliquePorItem(listaDeAlunos);
//        configuraListenerDeCliqueLongoPorItem(listaDeAlunos);
        registerForContextMenu(listaDeAlunos);
    }

// CONFIGURA CLIQUE LONGO NA LISTA
//    private void configuraListenerDeCliqueLongoPorItem(ListView listaDeAlunos) {
//        listaDeAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posicao, long id) {
//                Log.i("LongCliqueNoID: ", "" + posicao);
//                Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
//                remove(alunoEscolhido);
//                return false;
//            }
//        });
//    }

    private void configuraListenerDeCliquePorItem(ListView listaDeAlunos) {
        listaDeAlunos.setOnItemClickListener((adapterView, view, posicao, id) -> {
            Aluno alunoEscolhido = (Aluno) adapterView.getItemAtPosition(posicao);
            abreFormularioModoEditaAluno(alunoEscolhido);
        });
    }

    private void abreFormularioModoEditaAluno(Aluno alunoEscolhido) {
        Intent vaiProFormularioActivity = new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class);
        vaiProFormularioActivity.putExtra(CHAVE_ALUNO, alunoEscolhido);
        startActivity(vaiProFormularioActivity);
        Log.i("idAluno", String.valueOf(alunoEscolhido.getId()));
    }
}