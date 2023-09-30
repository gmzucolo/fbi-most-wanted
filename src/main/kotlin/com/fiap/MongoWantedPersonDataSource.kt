package com.fiap

import com.fiap.data.datasource.WantedPersonDataSource
import com.fiap.data.datasource.WantedPersonListDataSource
import com.fiap.data.model.WantedPerson
import com.fiap.data.model_response.RecentWantedListResponse
import org.litote.kmongo.coroutine.CoroutineDatabase
import org.litote.kmongo.eq

//private val client = KMongo.createClient()
//private val database = client.getDatabase("wanted-person")
//

class MongoWantedPersonDataSource(db: CoroutineDatabase) : WantedPersonDataSource, WantedPersonListDataSource {

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

    override suspend fun getRecentWantedList(): List<WantedPerson> {
        return wantedPerson.find().toList()
    }

    override suspend fun getRecentWantedListByPage(page: Int, pageSize: Int): List<WantedPerson> {
        val offset = (page - 1) * pageSize
        return wantedPerson.find().skip(offset).limit(pageSize).toList()
    }

    override suspend fun insertWantedPersonList(wantedPersonList: RecentWantedListResponse): Boolean {
        return wantedPerson.insertMany(wantedPersonList.items).wasAcknowledged()
    }
}