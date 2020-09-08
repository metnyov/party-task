package com.github.metnyov.party.presentation.screen.partylist

import android.os.Bundle
import android.view.View
import com.github.metnyov.party.R
import com.github.metnyov.party.domain.entity.Party
import com.github.metnyov.party.presentation.common.base.BaseFragment
import com.github.metnyov.party.presentation.view.adapter.ListItemAdapter
import kotlinx.android.synthetic.main.fragment_party_list.*
import moxy.ktx.moxyPresenter
import org.kodein.di.direct
import org.kodein.di.instance

class PartyListFragment : BaseFragment<PartyListPresenter>(R.layout.fragment_party_list),
    PartyListView {

    override val presenter: PartyListPresenter by moxyPresenter {
        PartyListPresenter(
            direct.instance(),
            direct.instance()
        )
    }

    private val partyAdapter by lazy {
        ListItemAdapter(
            presenter::onPartyPressed,
            getItemImageUrl = { it.imageUrl },
            getItemName = { it.name }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPartyList.adapter = partyAdapter
    }

    override fun showPartyList(partyList: List<Party>) {
        partyAdapter.submitList(partyList)
    }
}