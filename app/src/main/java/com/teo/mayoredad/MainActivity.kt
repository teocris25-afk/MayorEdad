package com.teo.mayoredad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edad: EditText = findViewById(R.id.edad)
        val boton: Button = findViewById(R.id.boton)
        val mensaje: TextView = findViewById(R.id.mensaje)

        val botonMas: Button = findViewById(R.id.sumar)
        val botonMenos: Button = findViewById(R.id.restar)

        botonMas.setOnClickListener {
            var valorActual = 0
            val numeroParseado = edad.text.toString().toIntOrNull()

            if (numeroParseado != null) {
                valorActual = numeroParseado
            }
            ++valorActual
            edad.setText(valorActual.toString())
            if (valorActual < 18) {
                mensaje.text = "No puedes entrar a la discoteca"
            } else  {
                mensaje.text = "Puedes entrar a la discoteca"
            }
        }

        botonMenos.setOnClickListener {
            var valorActual = 0
            val numeroParseado = edad.text.toString().toIntOrNull()

            if (numeroParseado != null) {
                valorActual = numeroParseado
            }
            if (valorActual > 0) {
                --valorActual
                edad.setText(valorActual.toString())
                if (valorActual < 18) {
                    mensaje.text = "No puedes entrar a la discoteca"
                } else  {
                    mensaje.text = "Puedes entrar a la discoteca"
                }
            }
        }

        boton.setOnClickListener {

            val edadNumero = edad.text.toString().toIntOrNull()

            if (edadNumero == null) {
                mensaje.text = "Introduce una edad válida"
            } else if (edadNumero > 18) {
                mensaje.text = "Puedes entrar a la discoteca"
            } else if (edadNumero < 18) {
                mensaje.text = "No puedes entrar a la discoteca"
            } else {
                mensaje.text = "Pasas justo"
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}