package com.github.metnyov.party.presentation.screen.partylist.details

import com.github.metnyov.party.domain.interactor.GetPartyDetailsByIdUseCase
import com.github.metnyov.party.presentation.common.base.BasePresenter
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.presenterScope
import ru.terrakok.cicerone.Router

@InjectViewState
class PartyDetailsPresenter(
    private val args: PartyDetailsFragment.Args,
    private val router: Router,
    private val getPartyDetailsByIdUseCase: GetPartyDetailsByIdUseCase
) : BasePresenter<PartyDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        presenterScope.launch {
            val details = getPartyDetailsByIdUseCase(args.partyId)
            if (details != null) {
                viewState.showDetails(details)
            } else {
                viewState.showErrorLoadToast()
                router.exit()
            }
        }
    }

    fun onBackPressed() = router.exit()
}