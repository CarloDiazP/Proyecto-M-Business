package com.example.m_business.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.m_business.data.local.entities.FichaInscripcion

@Dao
interface FichaInscripcionDao {

    @Insert
    suspend fun insertFichaInscripcion(fichaInscripcion: FichaInscripcion): Long

    @Update
    suspend fun updateFichaInscripcion(fichaInscripcion: FichaInscripcion)

    @Query("SELECT * FROM FICHAS_INSCRIPCION WHERE FicNum = :FicNum")
    suspend fun getFichaInscripcionById(FicNum: Long): FichaInscripcion?

    @Query("SELECT * FROM FICHAS_INSCRIPCION WHERE FicSocCod = :SocCod")
    suspend fun getFichasBySocioId(SocCod: Long): List<FichaInscripcion>

    @Query("SELECT * FROM FICHAS_INSCRIPCION WHERE FicDepCod = :DepCod")
    suspend fun getFichasByDeporteId(DepCod: Long): List<FichaInscripcion>

    @Query("DELETE FROM FICHAS_INSCRIPCION WHERE FicNum = :FicNum")
    suspend fun deleteFichaInscripcionById(FicNum: Long)
}