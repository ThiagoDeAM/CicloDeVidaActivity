package com.example.cdv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val CDV_TAG = "CDV_TAG"
    private val CAMPO_DINAMICO = "CAMPO_DINAMICO"
    private lateinit var dinamicoEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(CDV_TAG, "onCreate ${this.localClassName}: Iniciando ciclo COMPLETO")

        dinamicoEt = EditText(this)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        dinamicoEt.layoutParams = params

        val linearLayout = findViewById<LinearLayout>(R.id.main)
        linearLayout.addView(dinamicoEt)

        savedInstanceState?.getString(CAMPO_DINAMICO).let {
            dinamicoEt.setText(it)
        }

        val button: Button = findViewById(R.id.outra_tela_bt)
        button.setOnClickListener{
            Intent(this, OtherActivity::class.java).let {
                startActivity(it)
            }
        }

    }

    override fun onStart() {
        super.onStart()
        // Inicio do ciclo de vida visivel
        Log.v(CDV_TAG, "onStart ${this.localClassName}: Iniciando ciclo VISÍVEL")
    }

    override fun onResume() {
        super.onResume()
        //Inicio do ciclo de vida em primeiro plano (foreground)
        Log.v(CDV_TAG, "onResume ${this.localClassName}: Iniciando ciclo FOREGROUND")
    }

    override fun onPause() {
        super.onPause()
        // Final do ciclo de vida em primeiro plano (foreground)
        Log.v(CDV_TAG, "onPause ${this.localClassName}: Finalizando ciclo FOREGROUND")
    }

    override fun onStop() {
        super.onStop()
        // Final do ciclo de vida visivel
        Log.v(CDV_TAG, "onStop ${this.localClassName}: Finalizando ciclo VISÍVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Final do ciclo de vida completo, executado uma única vez por instância
        Log.v(CDV_TAG, "onDestroy ${this.localClassName}: Finalizando ciclo COMPLETO")
    }

    override fun onRestart() {
        super.onRestart()
        // Executado antes do onStart, não inicia ciclo nenhum
        Log.v(CDV_TAG, "onRestart ${this.localClassName}: Preparando execução do onStart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(CAMPO_DINAMICO, dinamicoEt.text.toString())
        Log.v(CDV_TAG, "onSaveInstanceState ${this.localClassName}: Salvando dados de instância ${this.hashCode()}")
    }

    /*
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        dinamicoEt.setText(savedInstanceState.getString(CAMPO_DINAMICO))
        Log.v(CDV_TAG, "onRestoreInstanceState ${this.localClassName}: Restaurando dados de instância ${this.hashCode()}")
    }
    */
}