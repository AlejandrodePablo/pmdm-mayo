package com.example.pmdm_mayo.features.clients.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CLIENT_TABLE = "client_table"
const val CLIENT_DNI = "client_id"

@Entity(tableName = CLIENT_TABLE)
class ClientEntity(
    @PrimaryKey @ColumnInfo(name = CLIENT_DNI) val dni: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String
)