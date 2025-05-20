package com.example.pmdm_mayo.features.clients.di

import com.example.pmdm_mayo.app.data.local.db.PmdmMayoDataBase
import com.example.pmdm_mayo.features.clients.data.local.db.ClientDao
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class ClientModule {

    @Single
    fun provideClientDao(db:PmdmMayoDataBase): ClientDao {
        return db.clientDao()
    }

}