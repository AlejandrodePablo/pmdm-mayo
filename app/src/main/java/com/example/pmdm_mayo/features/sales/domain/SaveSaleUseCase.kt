package com.example.pmdm_mayo.features.sales.domain

import org.koin.core.annotation.Single

@Single
class SaveSaleUseCase(private val repository: SaleRepository) {
    suspend operator fun invoke(sale: Sale) {
        repository.saveSale(sale)
    }
}