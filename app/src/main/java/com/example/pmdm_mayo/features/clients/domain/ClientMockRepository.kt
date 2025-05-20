package com.example.pmdm_mayo.features.clients.domain

import com.example.pmdm_mayo.features.clients.data.local.mock.ClientMockLocalDataSource
import org.koin.core.annotation.Single

@Single
class ClientMockRepository : ClientRepository {

    private val mock = ClientMockLocalDataSource()
    private var clients = mock.getClients().toMutableList()

    override suspend fun getClients(): List<Client> {
        return clients
    }

    override suspend fun deleteClient(dni: String) {
        clients.removeIf { it.dni == dni }
    }
}