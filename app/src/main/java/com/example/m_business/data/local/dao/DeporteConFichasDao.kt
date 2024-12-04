package com.example.m_business.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.m_business.data.local.relations.DeporteConFichas

@Dao
interface DeporteConFichasDao {

    @Transaction
    @Query("SELECT * FROM TIPOS_DEPORTE WHERE DepCod = :DepCod")
    suspend fun getDeporteConFichasById(DepCod: Long): DeporteConFichas?

    @Transaction
    @Query("SELECT * FROM TIPOS_DEPORTE")
    suspend fun getAllDeportesConFichas(): List<DeporteConFichas>
}