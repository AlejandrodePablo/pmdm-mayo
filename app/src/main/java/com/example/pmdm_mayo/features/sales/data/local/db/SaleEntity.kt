package com.example.pmdm_mayo.features.sales.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val SALE_TABLE = "sale"
const val SALE_ID = "id_sale"

@Entity(tableName = SALE_TABLE)
data class SaleEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = SALE_ID) val id: Int = 0,
    @ColumnInfo(name = "client_dni") val clientDni: String,
    @ColumnInfo(name = "concept") val concept: String,
    @ColumnInfo(name = "total") val total: Double
)