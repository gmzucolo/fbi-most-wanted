package com.fiap.di

import com.fiap.MongoWantedPersonDataSource
import com.fiap.data.datasource.WantedPersonDataSource
import com.fiap.repository.DatabaseFactory
import org.koin.dsl.module

val koinModule = module {
    single { DatabaseFactory().initConnectionDb() }
    single<WantedPersonDataSource> {
        MongoWantedPersonDataSource(get())
    }
}