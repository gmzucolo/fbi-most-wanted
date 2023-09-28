package com.fiap.service

import com.fiap.models.WantedPerson
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class WantedPersonService(private val database: Database) {
    private object RecentWantedList : Table() {

        val id = text("01")
        val ageMax = integer("ageMax")
        val ageMin = integer("ageMin")
        val caution = text("caution")
        val status = text("status")
        val description = text("description")
        val details = text("details")
        val hair = text("hair")
        val heightMax = integer("heightMax")
        val heightMin = integer("heightMin")
        val locations = text("locations")
        val nationality = text("nationality")
        val personClassification = text("personClassification")
        val placeOfBirth = text("placeOfBirth")
        val possibleCountries = text("possibleCountries")
        val race = text("race")
        val sex = text("sex")
        val title = text("title")
        val uid = text("uid")

        override val primaryKey = PrimaryKey(id)
    }

    init {
        transaction(database) {
            SchemaUtils.create(RecentWantedList)
        }
    }

    private suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }

    suspend fun getRecentWantedList(): List<WantedPerson> = dbQuery {
        RecentWantedList.selectAll().map { row -> row.toWantedPerson()
        }
    }

    suspend fun getWantedPersonById(id: String): WantedPerson? = dbQuery {
        RecentWantedList.select { RecentWantedList.id eq id }
            .map { row -> row.toWantedPerson() }
            .singleOrNull()
    }

    suspend fun getRecentWantedList(page: String): List<WantedPerson> = dbQuery {
        RecentWantedList.selectAll().map { row -> row.toWantedPerson() }
    }

    suspend fun save(wantedPerson: WantedPerson): WantedPerson = dbQuery {
        val id = RecentWantedList.insertIgnore {
            it[ageMax] = wantedPerson.ageMax
            it[ageMin] = wantedPerson.ageMin
            it[caution] = wantedPerson.caution
            it[status] = wantedPerson.status
            it[description] = wantedPerson.description
            it[details] = wantedPerson.details
            it[hair] = wantedPerson.hair
            it[heightMax] = wantedPerson.heightMax
            it[heightMin] = wantedPerson.heightMin
            it[locations] = wantedPerson.locations.joinToString(",")
            it[nationality] = wantedPerson.nationality
            it[personClassification] = wantedPerson.personClassification
            it[placeOfBirth] = wantedPerson.placeOfBirth
            it[possibleCountries] = wantedPerson.possibleCountries.joinToString(",")
            it[race] = wantedPerson.race
            it[sex] = wantedPerson.sex
            it[title] = wantedPerson.title
            it[uid] = wantedPerson.uid
        }.let {
            it[RecentWantedList.id]
        }

        wantedPerson.copy(id = id)
    }

    suspend fun delete(id: String) = dbQuery {
        RecentWantedList.deleteWhere {
            RecentWantedList.id eq id
        }
    }

    private fun ResultRow.toWantedPerson() = WantedPerson(
        id = this[RecentWantedList.id],
        ageMax = this[RecentWantedList.ageMax],
        ageMin = this[RecentWantedList.ageMin],
        caution = this[RecentWantedList.caution],
        status = this[RecentWantedList.status],
        description = this[RecentWantedList.description],
        details = this[RecentWantedList.details],
        hair = this[RecentWantedList.hair],
        heightMax = this[RecentWantedList.heightMax],
        heightMin = this[RecentWantedList.heightMin],
        locations = this[RecentWantedList.locations].split(","),
        nationality = this[RecentWantedList.nationality],
        personClassification = this[RecentWantedList.personClassification],
        placeOfBirth = this[RecentWantedList.placeOfBirth],
        possibleCountries = this[RecentWantedList.possibleCountries].split(","),
        race = this[RecentWantedList.race],
        sex = this[RecentWantedList.sex],
        title = this[RecentWantedList.title],
        uid = this[RecentWantedList.uid],
    )
}
