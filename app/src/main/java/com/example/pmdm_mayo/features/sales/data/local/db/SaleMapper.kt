package com.example.pmdm_mayo.features.sales.data.local.db

import com.example.pmdm_mayo.features.sales.domain.Sale

fun SaleEntity.toDomain(): Sale = Sale(
    id = this.id,
    clientDni = this.clientDni,
    concept = this.concept,
    total = this.total
)

fun Sale.toEntity(): SaleEntity = SaleEntity(
    id = this.id,
    clientDni = this.clientDni,
    concept = this.concept,
    total = this.total
)