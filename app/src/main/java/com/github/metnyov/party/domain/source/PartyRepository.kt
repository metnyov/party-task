package com.github.metnyov.party.domain.source

import com.github.metnyov.party.domain.entity.Party
import com.github.metnyov.party.domain.entity.PartyDetails

interface PartyRepository {

    suspend fun getPartyList(): List<Party>

    suspend fun getPartyDetailById(partyId: Long): PartyDetails?
}