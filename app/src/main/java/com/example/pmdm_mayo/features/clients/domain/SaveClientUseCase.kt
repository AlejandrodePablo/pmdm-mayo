package com.example.pmdm_mayo.features.clients.domain

import org.koin.core.annotation.Single

@Single
class SaveClientUseCase(private val repository: ClientRepository) {
    suspend operator fun invoke(client: Client) {
        repository.saveClient(client)
    }
}
