package com.github.metnyov.party.presentation.screen.partylist.details

import com.github.metnyov.party.domain.entity.PartyDetails
import com.github.metnyov.party.presentation.common.base.BaseView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PartyDetailsView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showDetails(partyDetails: PartyDetails)

    @StateStrategyType(SkipStrategy::class)
    fun showErrorLoadToast()
}