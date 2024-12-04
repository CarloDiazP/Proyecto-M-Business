package com.example.m_business

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.m_business.data.database.AppDatabase
import com.example.m_business.data.local.entities.Deporte
import com.example.m_business.data.local.entities.FichaInscripcion
import com.example.m_business.data.local.entities.Socio
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()

        lifecycleScope.launch {
            // Inserción de datos de ejemplo

            // Insertar un nuevo Socio
            val socio = Socio(
                SocNom = "Juan Perez",
                SocEstReg = 'A'
            )
            val socioId = db.socioDao().insertSocio(socio)
            Log.d("socioId", "$socioId")

            // Insertar un nuevo Deporte
            val deporte = Deporte(
                DepNom = "Futbol",
                DepEstReg = 'A'
            )
            val deporteId = db.deporteDao().insertDeporte(deporte)
            Log.d("deporteId", "$deporteId")

            // Insertar una Ficha de Inscripción
            val fichaInscripcion = FichaInscripcion(
                FicSocCod = socioId,
                FicDepCod = deporteId,
                FicFecDia = "15",
                FicFecMes = "12",
                FicFecAno = "2024",
                FicMon = 100.0,
                FicEstReg = 'A'
            )
            val fichaId = db.fichaInscripcionDao().insertFichaInscripcion(fichaInscripcion)
            Log.d("fichaId", "$fichaId")

            // Consultar Socio con sus Fichas (Relación Uno-a-Muchos)
            val socioConFichas = db.socioConFichasDao().getSocioConFichasById(socioId)
            Log.d("MainActivity", "Socio con sus fichas: $socioConFichas")

            // Consultar Deporte con sus Fichas (Relación Uno-a-Muchos)
            val deporteConFichas = db.deporteConFichasDao().getDeporteConFichasById(deporteId)
            Log.d("MainActivity", "Deporte con sus fichas: $deporteConFichas")

            // Consultar FichaInscripcion por Socio
            val fichasPorSocio = db.fichaInscripcionDao().getFichasBySocioId(socioId)
            Log.d("MainActivity", "Fichas por socio: $fichasPorSocio")

            // Consultar FichaInscripcion por Deporte
            val fichasPorDeporte = db.fichaInscripcionDao().getFichasByDeporteId(deporteId)
            Log.d("MainActivity", "Fichas por deporte: $fichasPorDeporte")
        }


    }
}