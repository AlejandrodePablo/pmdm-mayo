package com.example.pmdm_mayo.app.di

import android.content.Context
import androidx.room.Room
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

//    @Single
//    fun provideDataBase(context: Context): PracExamDataBase {
//        val db = Room.databaseBuilder(
//            context,
//            PracExamDataBase::class.java,
//            "prac-exam-db"
//        )
//        db.fallbackToDestructiveMigration()
//        return db.build()
//    }
}