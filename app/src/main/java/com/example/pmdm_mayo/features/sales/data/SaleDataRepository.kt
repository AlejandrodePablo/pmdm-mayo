package com.example.pmdm_mayo.features.sales.data

import com.example.pmdm_mayo.features.sales.data.local.db.SaleDbLocalDataSource
import com.example.pmdm_mayo.features.sales.domain.Sale
import com.example.pmdm_mayo.features.sales.domain.SaleRepository
import org.koin.core.annotation.Single

@Single
class SaleDataRepository(
    private val local: SaleDbLocalDataSource
) : SaleRepository {

    override suspend fun saveSale(sale: Sale) {
        local.saveSale(sale)
    }
}