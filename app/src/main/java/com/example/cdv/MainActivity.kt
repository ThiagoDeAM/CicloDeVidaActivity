package com.example.cdv

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private final val CDV_TAG = "CDV_TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.v(CDV_TAG, "onCreate: Iniciando ciclo COMPLETO")

    }

    override fun onStart() {
        super.onStart()
        // Inicio do ciclo de vida visivel
        Log.v(CDV_TAG, "onStart: Iniciando ciclo VISÍVEL")
    }

    override fun onResume() {
        super.onResume()
        //Inicio do ciclo de vida em primeiro plano (foreground)
        Log.v(CDV_TAG, "onResume: Iniciando ciclo FOREGROUND")
    }

    override fun onPause() {
        super.onPause()
        // Final do ciclo de vida em primeiro plano (foreground)
        Log.v(CDV_TAG, "onPause: Finalizando ciclo FOREGROUND")
    }

    override fun onStop() {
        super.onStop()
        // Final do ciclo de vida visivel
        Log.v(CDV_TAG, "onStop: Finalizando ciclo VISÍVEL")
    }

    override fun onDestroy() {
        super.onDestroy()
        // Final do ciclo de vida completo, executado uma única vez por instância
        Log.v(CDV_TAG, "onDestroy: Finalizando ciclo COMPLETO")
    }

    override fun onRestart() {
        super.onRestart()
        // Executado antes do onStart, não inicia ciclo nenhum
        Log.v(CDV_TAG, "onRestart: Preparando execução do onStart")
    }
}