package com.example.pmdm_mayo.features.clients.domain

import org.koin.core.annotation.Single

@Single
class GetClientsUseCase(private val repository: ClientRepository) {
    suspend operator fun invoke(): List<Client> {
        return repository.getClients()
    }
}