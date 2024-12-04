package com.example.m_business.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SOCIOS")
data class Socio(
    @PrimaryKey(autoGenerate = true) val SocCod: Long = 0,
    val SocNom: String,
    val SocEstReg: Char
)
