package com.example.m_business.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TIPOS_DEPORTE")
data class Deporte(
    @PrimaryKey(autoGenerate = true) val DepCod: Long = 0,
    val DepNom: String,
    val DepEstReg: Char
)
