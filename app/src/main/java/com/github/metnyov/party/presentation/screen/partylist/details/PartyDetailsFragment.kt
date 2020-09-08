package com.github.metnyov.party.presentation.screen.partylist.details

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.github.metnyov.party.R
import com.github.metnyov.party.domain.entity.PartyDetails
import com.github.metnyov.party.domain.entity.Person
import com.github.metnyov.party.presentation.common.args.FragmentArgs
import com.github.metnyov.party.presentation.common.base.BaseFragmentWithArgs
import com.github.metnyov.party.presentation.view.adapter.ListItemAdapter
import com.github.metnyov.party.presentation.view.extensions.load
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_party_details.*
import moxy.ktx.moxyPresenter
import org.kodein.di.direct
import org.kodein.di.instance

class PartyDetailsFragment :
    BaseFragmentWithArgs<PartyDetailsPresenter, PartyDetailsFragment.Args>(R.layout.fragment_party_details),
    PartyDetailsView {

    override val presenter: PartyDetailsPresenter by moxyPresenter {
        PartyDetailsPresenter(
            args,
            direct.instance(),
            direct.instance()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarPartyDetails.setNavigationOnClickListener { presenter.onBackPressed() }
    }

    override fun showDetails(partyDetails: PartyDetails) = with(partyDetails) {
        ivPartyDetailsBanner.load(imageUrl, R.drawable.img_placeholder_rect, false)

        ivPartyDetailsInvitedByPhoto.load(invitedBy.photoUrl)
        tvPartyDetailsInvitedBy.text = getString(R.string.party_details_invited_by, invitedBy.name)

        tvPartyDetailsName.text = name

        tvPartyDetailsComeWithYouTitle.setText(
            if (comeWithYou.isNotEmpty()) {
                R.string.party_details_come_with_you
            } else {
                R.string.party_details_nobody_come_with_you
            }
        )
        rvPartyDetailsComeWithYou.run {
            isVisible = comeWithYou.isNotEmpty()
            adapter = ListItemAdapter<Person>(
                itemClickListener = {},
                getItemImageUrl = { it.photoUrl },
                getItemName = { it.name }
            ).apply {
                submitList(comeWithYou)
            }
        }
    }

    override fun showErrorLoadToast() {
        context?.let {
            Toast.makeText(it, R.string.party_details_load_error, Toast.LENGTH_SHORT).show()
        }
    }

    @Parcelize
    data class Args(
        val partyId: Long
    ) : FragmentArgs<PartyDetailsFragment>()
}