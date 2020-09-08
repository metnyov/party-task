package com.github.metnyov.party.data.entity

import com.squareup.moshi.Json

data class NwPerson(

	@Json(name = "id")
	val id: Long? = null,

	@Json(name = "name")
	val name: String? = null,

	@Json(name = "photo_url")
	val photoUrl: String? = null
)