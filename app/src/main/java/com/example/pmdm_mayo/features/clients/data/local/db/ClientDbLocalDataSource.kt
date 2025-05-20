package com.example.pmdm_mayo.features.clients.data.local.db

import com.example.pmdm_mayo.features.clients.domain.Client
import org.koin.core.annotation.Single

@Single
class ClientDbLocalDataSource(private val dao: ClientDao) {

    suspend fun getClients(): List<Client> {
       val clients = dao.findAll()
        return if (clients.isEmpty()){
            emptyList()
        }else{
            clients.map { it.toDomain() }
        }
    }
    suspend fun deleteClient(dni: String) {
        dao.deleteByDni(dni)
    }

    suspend fun saveClients(clients: List<Client>) {
        dao.saveAll(*clients.map { it.toEntity() }.toTypedArray())
    }
    suspend fun saveClient(client: Client) {
        dao.saveAll(client.toEntity())
    }

}