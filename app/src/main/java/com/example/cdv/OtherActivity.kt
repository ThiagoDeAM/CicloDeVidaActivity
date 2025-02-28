package com.example.cdv

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OtherActivity : AppCompatActivity() {
    private val CDV_TAG = "CDV_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        Log.v(CDV_TAG, "onCreate ${this.localClassName}: Iniciando ciclo COMPLETO")
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
}