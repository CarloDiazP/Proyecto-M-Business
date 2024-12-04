package com.example.m_business.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.m_business.data.local.relations.SocioConFichas

@Dao
interface SocioConFichasDao {

    @Transaction
    @Query("SELECT * FROM SOCIOS WHERE SocCod = :SocCod")
    suspend fun getSocioConFichasById(SocCod: Long): SocioConFichas?

    @Transaction
    @Query("SELECT * FROM SOCIOS")
    suspend fun getAllSociosConFichas(): List<SocioConFichas>
}