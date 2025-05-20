package com.example.pmdm_mayo.features.clients.data

import com.example.pmdm_mayo.features.clients.data.local.db.ClientDbLocalDataSource
import com.example.pmdm_mayo.features.clients.data.local.mock.ClientMockLocalDataSource
import com.example.pmdm_mayo.features.clients.domain.Client
import com.example.pmdm_mayo.features.clients.domain.ClientRepository

class ClientDataRepository(
    private val local: ClientDbLocalDataSource,
    private val mock: ClientMockLocalDataSource
): ClientRepository{
    override suspend fun getClients(): List<Client> {
        val clients = local.getClients()
        if (clients.isEmpty()) {
            val mockClients = mock.getClients()
            local.saveClients(mockClients)
        }
        return clients
    }

    override suspend fun deleteClient(dni: String) {
        local.deleteClient(dni)
    }
}