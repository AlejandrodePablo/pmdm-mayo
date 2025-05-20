package com.example.pmdm_mayo.features.clients.data

import com.example.pmdm_mayo.features.clients.data.local.db.ClientDbLocalDataSource
import com.example.pmdm_mayo.features.clients.data.local.mock.ClientMockLocalDataSource
import com.example.pmdm_mayo.features.clients.domain.Client
import com.example.pmdm_mayo.features.clients.domain.ClientRepository
import com.example.pmdm_mayo.features.sales.data.local.db.SaleDao
import org.koin.core.annotation.Single

@Single
class ClientDataRepository(
    private val local: ClientDbLocalDataSource,
    private val mock: ClientMockLocalDataSource,
    private val saleDao: SaleDao
): ClientRepository{
    override suspend fun getClients(): List<Client> {
        val clients = local.getClients()
        return if (clients.isEmpty()) {
            val mockClients = mock.getClients()
            local.saveClients(mockClients)
            enrichWithVip(mockClients)
        } else {
            enrichWithVip(clients)
        }
    }

    private suspend fun enrichWithVip(clients: List<Client>): List<Client> {
        return clients.map { client ->
            val salesCount = saleDao.countSalesByClient(client.dni)
            client.copy(isVip = salesCount >= 5)
        }
    }

    override suspend fun deleteClient(dni: String) {
        local.deleteClient(dni)
    }

    override suspend fun saveClient(client: Client) {
        local.saveClient(client)
    }

}