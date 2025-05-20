package com.example.pmdm_mayo.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pmdm_mayo.features.clients.data.local.db.ClientDao
import com.example.pmdm_mayo.features.clients.data.local.db.ClientEntity

@Database(
    entities = [ClientEntity::class],
    version = 1,
    exportSchema = false
)

abstract class PmdmMayoDataBase: RoomDatabase() {
    abstract fun clientDao(): ClientDao
}