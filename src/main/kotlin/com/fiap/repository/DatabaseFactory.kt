package com.fiap.repository

import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

class DatabaseFactory {

    fun initConnectionDb(): CoroutineDatabase {
        val mongoPw = System.getenv("MONGO_PW")
        val dbName = "Cluster0"
        return KMongo.createClient(
            connectionString = "mongodb+srv://gmzucolo:M6endes3.@cluster0.2iu7pat.mongodb.net/$dbName?retryWrites=true&w=majority&appName=AtlasApp").coroutine.getDatabase(dbName)
    }
}