package com.example.m_business.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.m_business.data.local.dao.DeporteConFichasDao
import com.example.m_business.data.local.dao.DeporteDao
import com.example.m_business.data.local.dao.FichaInscripcionDao
import com.example.m_business.data.local.dao.SocioConFichasDao
import com.example.m_business.data.local.dao.SocioDao
import com.example.m_business.data.local.entities.Deporte
import com.example.m_business.data.local.entities.FichaInscripcion
import com.example.m_business.data.local.entities.Socio

@Database(entities = [Deporte::class, FichaInscripcion::class, Socio::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun deporteDao(): DeporteDao
    abstract fun fichaInscripcionDao(): FichaInscripcionDao
    abstract fun socioDao(): SocioDao
    abstract fun deporteConFichasDao(): DeporteConFichasDao
    abstract fun socioConFichasDao(): SocioConFichasDao
}