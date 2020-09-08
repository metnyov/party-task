package com.github.metnyov.party.data.entity

import com.squareup.moshi.Json

data class NwPartyDetails(

	@Json(name = "id")
	val id: Long? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "image_url")
	val imageUrl: String? = null,

	@Json(name = "invited_by")
	val invitedBy: NwPerson? = null,

	@Json(name = "come_with_you")
	val comeWithYou: List<NwPerson?>? = null
)