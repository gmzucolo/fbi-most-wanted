package com.fiap

import com.fiap.data.datasource.WantedPersonDataSource
import com.fiap.data.model.WantedPerson
import org.litote.kmongo.*
import org.litote.kmongo.coroutine.CoroutineDatabase

private val client = KMongo.createClient()
private val database = client.getDatabase("wanted-persons")


class MongoWantedPersonDataSource(db: CoroutineDatabase) : WantedPersonDataSource {

    private val wantedPerson = db.getCollection<WantedPerson>()

    override suspend fun getWantedPersonById(id: String): WantedPerson? {
        return wantedPerson.findOneById(WantedPerson::id eq id)
    }

    suspend fun createWantedPersonOrUpdateById(newWantedPerson: WantedPerson): Boolean {
        val wantedPersonExists = wantedPerson.findOneById(newWantedPerson.id) != null
        return if (wantedPersonExists) {
            wantedPerson.updateOneById(newWantedPerson.id, wantedPerson).wasAcknowledged()
        } else {
            wantedPerson.insertOne(newWantedPerson).wasAcknowledged()
        }
    }
}