package br.com.pradoeduardoluiz.rickandmortyapp.data.di

import br.com.pradoeduardoluiz.rickandmortyapp.data.NetworkApi
import org.koin.dsl.module

val dataModule = module {
    single { NetworkApi.provideOkkHttpClient() }
    single { NetworkApi.provideConverterFactory() }
    factory {
        NetworkApi.getClient(
            okHttpClient = get(),
            converterFactory = get()
        )
    }
}

