package com.example.m_business.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.m_business.data.local.entities.Deporte
import com.example.m_business.data.local.entities.FichaInscripcion

data class DeporteConFichas(
    @Embedded val deporte: Deporte,
    @Relation(
        parentColumn = "DepCod",
        entityColumn = "FicDepCod"
    )
    val fichas: List<FichaInscripcion>
)
