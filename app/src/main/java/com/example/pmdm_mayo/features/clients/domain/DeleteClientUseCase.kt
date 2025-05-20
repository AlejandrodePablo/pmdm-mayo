package com.example.pmdm_mayo.features.clients.domain

import org.koin.core.annotation.Single

@Single
class DeleteClientUseCase(private val repository: ClientRepository) {
    suspend operator fun invoke(dni: String) {
        repository.deleteClient(dni)
    }
}