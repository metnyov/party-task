package com.github.metnyov.party.domain.interactor

import com.github.metnyov.party.domain.entity.Party
import com.github.metnyov.party.domain.source.PartyRepository

class GetPartyListUseCase(
    private val partyRepository: PartyRepository
) {

    suspend operator fun invoke(): List<Party> = partyRepository.getPartyList()
}