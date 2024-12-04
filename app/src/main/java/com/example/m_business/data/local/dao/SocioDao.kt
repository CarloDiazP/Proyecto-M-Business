package com.example.m_business.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.m_business.data.local.entities.Socio

@Dao
interface SocioDao {

    @Insert
    suspend fun insertSocio(socio: Socio): Long

    @Update
    suspend fun updateSocio(socio: Socio)

    @Query("SELECT * FROM SOCIOS WHERE SocCod = :SocCod")
    suspend fun getSocioById(SocCod: Long): Socio?

    @Query("SELECT * FROM SOCIOS")
    suspend fun getAllSocios(): List<Socio>

    @Query("DELETE FROM SOCIOS WHERE SocCod = :SocCod")
    suspend fun deleteSocioById(SocCod: Long)
}