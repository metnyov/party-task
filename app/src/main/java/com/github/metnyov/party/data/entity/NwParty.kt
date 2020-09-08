package com.github.metnyov.party.data.entity

import com.squareup.moshi.Json

data class NwParty(

	@Json(name = "id")
	val id: Long? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "image_url")
	val imageUrl: String? = null
)
