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

    private fun numberGenerator(text:String, txtResult: TextView) {
        //Validar quando o campo está Vazio
        if (text.isNotEmpty()){

            val qtd = text.toInt() //Converte String para Numero Inteiro
            if (qtd >= 15 && qtd <= 20){ // validar se o campo informado é entre 15 e 20

                val numbers = mutableSetOf<Int>()
                val random = Random()

                while (true){
                    val number = random.nextInt(25) // aqui aonde eu indico de 0 ... aos 25 numeros que poderam ser sorteador
                    numbers.add(number + 1)

                    if (numbers.size == qtd){
                        break
                    }
                }

               txtResult.text = numbers.joinToString("-")

            } else {
                Toast.makeText(this, "Informe um Número de 15 a 20", Toast.LENGTH_SHORT).show()
            }

        } else {
            Toast.makeText(this, "Informe um Número", Toast.LENGTH_SHORT).show()
        }

    }

}