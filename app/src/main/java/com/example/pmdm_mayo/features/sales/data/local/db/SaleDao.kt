package com.example.pmdm_mayo.features.sales.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SaleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSale(sale: SaleEntity)

    @Query("SELECT COUNT(*) FROM $SALE_TABLE WHERE client_dni = :dni")
    suspend fun countSalesByClient(dni: String): Int
}