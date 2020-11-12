package com.example.tareaentregalisteners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    //1. Crear botón y un editText. Cuando el boton en el que pone "comenzar" se pulsa,
    //el editText aparece y en e boton para a poner "finalizar". Si se vuelve a pulsar
    //el boton, el editText desaparece.

    //2. Cuando el editText tenga hasFocus, hacer borrado del contenido de text. Cuando
    //no tenga hasFocus y no se ha escrito nada que vuelva a poner "Introduce tu nombre".

    //3. Comparar el contenido del edittext para ver si contiene la palabra Wayne o la palabra joker.
    //Si esta Wayne  aparecera un imageView con el logo de batman que esta en la carpeta
    //drawable; si por el contrario esta joker, los colores de toda la app deberán cambiar.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i = 0;

        var b1 = findViewById<Button>(R.id.b1)
        var et1 = findViewById<EditText>(R.id.et1)

        //Apartado1
        b1.setOnClickListener {
            b1.setText("Finalizar")
            if (i==0){
                et1.setVisibility(View.VISIBLE)
                i++
            } else {
                et1.setVisibility(View.GONE)
                i--
            }
        }

        //Apartado2
        et1.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                et1.text.clear()
                et1.addTextChangedListener(textWatcher)
            }
            //No se si realmente tengo que hacer un textWatcher

            if (!hasFocus && et1.text.isEmpty()) {
                et1.setText("Introduce tu nombre")
            }
        }


    }
}