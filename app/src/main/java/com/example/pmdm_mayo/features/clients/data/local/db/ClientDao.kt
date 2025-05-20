package com.example.pmdm_mayo.features.clients.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ClientDao {


    @Query("SELECT * FROM $CLIENT_TABLE")
    suspend fun findAll(): List<ClientEntity>

    @Query("DELETE FROM $CLIENT_TABLE WHERE $CLIENT_DNI = :dni")
    suspend fun deleteByDni(dni: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAll(vararg clients: ClientEntity)
}
