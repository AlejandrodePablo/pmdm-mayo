package com.example.pmdm_mayo.features.clients.data.local.db

import com.example.pmdm_mayo.features.clients.domain.Client

fun ClientEntity.toDomain(): Client = Client(
    dni = this.dni,
    name = this.name,
    email = this.email,
    isVip = false
)

fun Client.toEntity(): ClientEntity = ClientEntity(
    dni = this.dni,
    name = this.name,
    email = this.email
)
