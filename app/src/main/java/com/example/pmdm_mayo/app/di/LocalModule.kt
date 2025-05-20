package com.example.pmdm_mayo.app.di

import android.content.Context
import androidx.room.Room
import com.example.pmdm_mayo.app.data.local.db.PmdmMayoDataBase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDataBase(context: Context): PmdmMayoDataBase {
        val db = Room.databaseBuilder(
            context,
            PmdmMayoDataBase::class.java,
            "pmdm-mayo-db"
        )
        db.fallbackToDestructiveMigration()
        return db.build()
    }
}