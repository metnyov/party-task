package com.github.metnyov.party.di

import com.github.metnyov.party.data.repository.PartyRepositoryImpl
import com.github.metnyov.party.domain.source.PartyRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val sourceModule = DI.Module("source") {

    // Repositories
    bind<PartyRepository>() with singleton { PartyRepositoryImpl(instance()) }
}