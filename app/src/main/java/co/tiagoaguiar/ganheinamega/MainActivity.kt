package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        btnGenerate.setOnClickListener {

            val text = editText.text.toString()

            numberGenerator(text, txtResult)
        }
    }

    fun calcular(x: Int, y: Int): Int{
        return 0
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        // Falha número 1
        if (text.isNotEmpty()) {
            Toast.makeText(this, "Informe um Número de 15 a 20", Toast.LENGTH_SHORT).show()
        }

        val qtd = text.toInt()
        // Falha número 2
        if (qtd < 15 || qtd > 20) {
            Toast.makeText(this, "Informe um Número de 15 a 20", Toast.LENGTH_SHORT).show()
            return
        }

        // Aqui é o Sucesso
        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true) {
            val number =
                random.nextInt(25) // aqui aonde eu indico de 0 ... aos 25 numeros que poderam ser sorteados
            numbers.add(number + 1)

            if (numbers.size == qtd) {
                break
            }
        }

        txtResult.text = numbers.joinToString("-")

    }
}