package com.fiap.repository

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class DatabaseFactory {

    fun initConnectionDb(): CoroutineDatabase {
        val mongoPw = System.getenv("MONGO_PW")
        val dbName = "MostWantedDB"
        return KMongo.createClient(
            connectionString = "mongodb+srv://severino:$").coroutine.getDatabase(dbName)
    }
}