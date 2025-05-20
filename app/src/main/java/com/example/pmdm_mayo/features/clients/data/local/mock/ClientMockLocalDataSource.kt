package com.example.pmdm_mayo.features.clients.data.local.mock

import com.example.pmdm_mayo.features.clients.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientMockLocalDataSource {

    fun getClients(): List<Client> {
        return listOf(
            Client("11111111A", "Mario González", "mario@example.com", false),
            Client("22222222B", "Lucía Pérez", "lucia@example.com",false),
            Client("33333333C", "Carlos Torres", "carlos@example.com",false),
            Client("44444444D", "Sara López", "sara@example.com",false),
            Client("55555555E", "David Romero", "david@example.com",false),
            Client("66666666F", "Andrea Martín", "andrea@example.com",false),
            Client("77777777G", "Álvaro Ruiz", "alvaro@example.com",false),
            Client("88888888H", "Paula Fernández", "paula@example.com",false),
            Client("99999999J", "Hugo Ramírez", "hugo@example.com",false),
            Client("00000000K", "Laura Sánchez", "laura@example.com",false)
        )
    }
}