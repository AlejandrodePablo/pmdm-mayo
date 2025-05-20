package com.example.pmdm_mayo.app

import android.app.Application
import com.example.pmdm_mayo.app.di.AppModule
import com.example.pmdm_mayo.app.di.LocalModule
import com.example.pmdm_mayo.features.clients.di.ClientModule
import com.example.pmdm_mayo.features.sales.di.SaleModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class PmdmMayoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PmdmMayoApp)
            modules(
                AppModule().module,
                LocalModule().module,
                ClientModule().module,
                SaleModule().module
            )
        }
    }
}