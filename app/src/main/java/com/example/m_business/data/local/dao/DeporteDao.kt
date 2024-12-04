package com.example.m_business.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.m_business.data.local.entities.Deporte

@Dao
interface DeporteDao {

    @Insert
    suspend fun insertDeporte(deporte: Deporte): Long

    @Update
    suspend fun updateDeporte(deporte: Deporte)

    @Query("SELECT * FROM TIPOS_DEPORTE WHERE DepCod = :DepCod")
    suspend fun getDeporteById(DepCod: Long): Deporte?

    @Query("SELECT * FROM TIPOS_DEPORTE")
    suspend fun getAllDeportes(): List<Deporte>

    @Query("DELETE FROM TIPOS_DEPORTE WHERE DepCod = :DepCod")
    suspend fun deleteDeporteById(DepCod: Long)
}