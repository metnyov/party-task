package com.github.metnyov.party.presentation.screen.partylist

import com.github.metnyov.party.domain.entity.Party
import com.github.metnyov.party.presentation.common.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PartyListView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showPartyList(partyList: List<Party>)
}