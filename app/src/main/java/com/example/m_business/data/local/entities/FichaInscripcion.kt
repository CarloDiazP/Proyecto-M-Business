package com.example.m_business.data.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "FICHAS_INSCRIPCION",
    foreignKeys = [
        ForeignKey(
            entity = Socio::class,
            parentColumns = ["SocCod"],
            childColumns = ["FicSocCod"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Deporte::class,
            parentColumns = ["DepCod"],
            childColumns = ["FicDepCod"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class FichaInscripcion(
    @PrimaryKey(autoGenerate = true) val FicNum: Long = 0,
    val FicSocCod: Long,
    val FicDepCod: Long,
    val FicFecDia: String,
    val FicFecMes: String,
    val FicFecAno: String,
    val FicMon: Double,
    val FicEstReg: Char
)
