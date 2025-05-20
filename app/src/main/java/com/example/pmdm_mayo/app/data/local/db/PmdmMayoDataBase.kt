package com.example.pmdm_mayo.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pmdm_mayo.features.clients.data.local.db.ClientDao
import com.example.pmdm_mayo.features.clients.data.local.db.ClientEntity
import com.example.pmdm_mayo.features.sales.data.local.db.SaleDao
import com.example.pmdm_mayo.features.sales.data.local.db.SaleEntity

@Database(
    entities = [ClientEntity::class, SaleEntity::class],
    version = 2,
    exportSchema = false
)

abstract class PmdmMayoDataBase: RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun saleDao(): SaleDao
}