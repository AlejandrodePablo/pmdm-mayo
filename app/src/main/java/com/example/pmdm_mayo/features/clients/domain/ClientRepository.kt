package com.example.pmdm_mayo.features.clients.domain

interface ClientRepository {
    suspend fun getClients(): List<Client>
    suspend fun deleteClient(dni: String)
    suspend fun saveClient(client: Client)
}