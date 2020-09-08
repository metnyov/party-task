package com.github.metnyov.party.data.api

import com.github.metnyov.party.data.entity.NwParty
import com.github.metnyov.party.data.entity.NwPartyDetails

interface AppApi {

    fun getPartyList(): List<NwParty>

    fun getPartyDetails(partyId: Long): NwPartyDetails?
}