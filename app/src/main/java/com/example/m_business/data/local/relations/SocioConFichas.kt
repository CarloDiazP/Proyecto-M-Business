package com.example.m_business.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.m_business.data.local.entities.FichaInscripcion
import com.example.m_business.data.local.entities.Socio

data class SocioConFichas(
    @Embedded val socio: Socio,
    @Relation(
        parentColumn = "SocCod",
        entityColumn = "FicSocCod"
    )
    val fichas: List<FichaInscripcion>
)
