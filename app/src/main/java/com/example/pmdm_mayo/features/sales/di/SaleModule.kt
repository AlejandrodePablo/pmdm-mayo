package com.example.pmdm_mayo.features.sales.di

import com.example.pmdm_mayo.app.data.local.db.PmdmMayoDataBase
import com.example.pmdm_mayo.features.sales.data.local.db.SaleDao
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class SaleModule {

    @Single
    fun provideSaleDao(database: PmdmMayoDataBase): SaleDao {
        return database.saleDao()
    }
}