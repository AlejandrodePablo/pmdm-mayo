package com.example.pmdm_mayo.features.sales.data.local.db

import com.example.pmdm_mayo.features.sales.domain.Sale
import org.koin.core.annotation.Single

@Single
class SaleDbLocalDataSource(private val dao: SaleDao) {

    suspend fun saveSale(sale: Sale) {
        dao.saveSale(sale.toEntity())
    }
}