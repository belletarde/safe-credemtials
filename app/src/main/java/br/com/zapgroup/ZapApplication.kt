package br.com.zapgroup

import android.app.Application
import br.com.zapgroup.di.mainModule
import br.com.zapgroup.di.netModule
import br.com.zapgroup.di.repositoryModule
import br.com.zapgroup.di.serviceModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ZapApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ZapApplication)
            modules(netModule, serviceModule, repositoryModule, mainModule)
        }
    }
}