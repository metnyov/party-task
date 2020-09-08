package com.github.metnyov.party.presentation.screen.partylist

import com.github.metnyov.party.domain.entity.Party
import com.github.metnyov.party.domain.interactor.GetPartyListUseCase
import com.github.metnyov.party.presentation.common.base.BasePresenter
import com.github.metnyov.party.presentation.common.navigation.toScreen
import com.github.metnyov.party.presentation.screen.partylist.details.PartyDetailsFragment
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.presenterScope
import ru.terrakok.cicerone.Router

@InjectViewState
class PartyListPresenter(
    private val router: Router,
    private val getPartyListUseCase: GetPartyListUseCase
) : BasePresenter<PartyListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            viewState.showPartyList(getPartyListUseCase())
        }
    }

    fun onPartyPressed(party: Party) {
        router.navigateTo(PartyDetailsFragment.Args(party.id).toScreen())
    }
}