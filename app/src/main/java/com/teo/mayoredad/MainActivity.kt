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
            var valorActual = edad.text.toString().toIntOrNull() ?: 0
            valorActual++
            edad.setText(valorActual.toString())

            Mensaje(valorActual, mensaje)
        }

        botonMenos.setOnClickListener {
            var valorActual = edad.text.toString().toIntOrNull() ?: 0
            if (valorActual > 0) {
                valorActual--
                edad.setText(valorActual.toString())

                Mensaje(valorActual, mensaje)
            }
        }

        boton.setOnClickListener {
            val edadNumero = edad.text.toString().toIntOrNull()
            if (edadNumero == null) {
                mensaje.text = "Introduce una edad válida"
            } else {
                Mensaje(edadNumero, mensaje)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun Mensaje(edadValidar: Int, textViewMensaje: TextView) {
        if (edadValidar < 18) {
            textViewMensaje.text = "No puedes entrar a la discoteca"
        } else if (edadValidar == 18) {
            textViewMensaje.text = "Pasas justo"
        } else {
            textViewMensaje.text = "Puedes entrar a la discoteca"
        }

        /*
        private fun Mensaje(edadValidar:Int?, textViewMensaje:TextView) {
            val mensaje = when
            edad == null -> "Introduce una edad válida"
            edad < 18 -> "No puedes entrar a la discoteca"
            edad > 18 -> "Puedes entrar a la discoteca"
            else -> "Pasas justo"
            textViewMensaje.text = mensaje
        }

         */
    }
}