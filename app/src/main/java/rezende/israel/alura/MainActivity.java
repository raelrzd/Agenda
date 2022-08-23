package rezende.israel.alura;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // BALÃO INFERIOR AO ABRIR O APP
//        Toast.makeText(this, "Rael Rezende", Toast.LENGTH_LONG).show();
        // APRESENTA ARQUIVO DE ACTIVITY
        setContentView(R.layout.activity_main);

        List<String> alunos = new ArrayList<>(
                Arrays.asList("Raelzera", "Guizera", "Teteuzera"));
        ListView listaDeAlunos = findViewById(R.id.activity_main_lista_de_alunos);
        listaDeAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alunos));
            
    }
}