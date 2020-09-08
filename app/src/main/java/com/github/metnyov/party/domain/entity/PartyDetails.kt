package com.github.metnyov.party.domain.entity

data class PartyDetails(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val invitedBy: Person,
    val comeWithYou: List<Person>
)