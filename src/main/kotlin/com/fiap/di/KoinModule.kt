package com.fiap.di

import com.fiap.ConfigureNetwork
import com.fiap.MongoWantedPersonDataSource
import com.fiap.api.WantedPersonAPI
import com.fiap.api.WantedPersonImpl
import com.fiap.data.datasource.WantedPersonDataSource
import com.fiap.data.datasource.WantedPersonListDataSource
import com.fiap.repository.DatabaseFactory
import org.koin.dsl.module

val koinModule = module {

    single { ConfigureNetwork.httpClientInstance() }

    single { DatabaseFactory().initConnectionDb() }

    single<WantedPersonDataSource> {
        MongoWantedPersonDataSource(get())
    }

    single<WantedPersonListDataSource> {
        MongoWantedPersonDataSource(get())
    }

    single<WantedPersonAPI> {
        WantedPersonImpl(get())
    }
}