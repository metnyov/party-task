package com.github.metnyov.party.data.repository

import com.github.metnyov.party.data.api.AppApi
import com.github.metnyov.party.data.entity.NwParty
import com.github.metnyov.party.data.entity.NwPartyDetails
import com.github.metnyov.party.data.entity.NwPerson
import com.github.metnyov.party.domain.entity.Party
import com.github.metnyov.party.domain.entity.PartyDetails
import com.github.metnyov.party.domain.entity.Person
import com.github.metnyov.party.domain.source.PartyRepository

class PartyRepositoryImpl(
    private val appApi: AppApi
) : PartyRepository {

    override suspend fun getPartyList(): List<Party> {
        return appApi.getPartyList().mapNotNull { party ->
            mapParty(party)
        }
    }

    override suspend fun getPartyDetailById(partyId: Long): PartyDetails? {
        return mapPartyDetails(appApi.getPartyDetails(partyId))
    }

    private fun mapParty(nwParty: NwParty?): Party? = run {
        Party(
            id = nwParty?.id ?: return@run null,
            name = nwParty.name ?: return@run null,
            imageUrl = nwParty.imageUrl ?: ""
        )
    }

    private fun mapPerson(nwPerson: NwPerson?): Person? = run {
        Person(
            id = nwPerson?.id ?: return@run null,
            name = nwPerson.name ?: return@run null,
            photoUrl = nwPerson.photoUrl ?: "",
        )
    }

    private fun mapPartyDetails(nwPartyDetails: NwPartyDetails?): PartyDetails? = run {
        PartyDetails(
            id = nwPartyDetails?.id ?: return@run null,
            name = nwPartyDetails.name ?: return@run null,
            imageUrl = nwPartyDetails.imageUrl ?: "",
            invitedBy = mapPerson(nwPartyDetails.invitedBy) ?: return@run null,
            comeWithYou = nwPartyDetails.comeWithYou?.mapNotNull { mapPerson(it) } ?: emptyList()
        )
    }
}