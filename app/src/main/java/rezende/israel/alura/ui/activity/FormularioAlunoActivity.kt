package rezende.israel.alura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rezende.israel.alura.R

class FormularioAlunoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_aluno)
        setTitle("Novo Aluno")
    }
}