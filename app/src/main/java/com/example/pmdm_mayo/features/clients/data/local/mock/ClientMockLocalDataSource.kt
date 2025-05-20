package com.example.pmdm_mayo.features.clients.data.local.mock

import com.example.pmdm_mayo.features.clients.domain.Client

class ClientMockLocalDataSource {

    fun getClients(): List<Client> {
        return listOf(
            Client("11111111A", "Mario González", "mario@example.com"),
            Client("22222222B", "Lucía Pérez", "lucia@example.com"),
            Client("33333333C", "Carlos Torres", "carlos@example.com"),
            Client("44444444D", "Sara López", "sara@example.com"),
            Client("55555555E", "David Romero", "david@example.com"),
            Client("66666666F", "Andrea Martín", "andrea@example.com"),
            Client("77777777G", "Álvaro Ruiz", "alvaro@example.com"),
            Client("88888888H", "Paula Fernández", "paula@example.com"),
            Client("99999999J", "Hugo Ramírez", "hugo@example.com"),
            Client("00000000K", "Laura Sánchez", "laura@example.com")
        )
    }
}