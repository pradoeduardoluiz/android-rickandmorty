package br.com.pradoeduardoluiz.rickandmortyapp

import android.app.Application
import br.com.pradoeduardoluiz.rickandmortyapp.data.di.dataModule
import br.com.pradoeduardoluiz.rickandmortyapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApplication)
            modules(modules)
        }
    }

    private val modules = listOf(appModule, dataModule)
}
