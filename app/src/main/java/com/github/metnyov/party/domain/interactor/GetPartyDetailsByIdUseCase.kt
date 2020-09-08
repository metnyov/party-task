package com.github.metnyov.party.domain.interactor

import com.github.metnyov.party.domain.entity.PartyDetails
import com.github.metnyov.party.domain.source.PartyRepository

class GetPartyDetailsByIdUseCase(
    private val partyRepository: PartyRepository
) {

    suspend operator fun invoke(partyId: Long): PartyDetails? =
        partyRepository.getPartyDetailById(partyId)
}