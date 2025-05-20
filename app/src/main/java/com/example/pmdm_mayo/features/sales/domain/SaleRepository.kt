package com.example.pmdm_mayo.features.sales.domain

interface SaleRepository {
    suspend fun saveSale(sale: Sale)
}