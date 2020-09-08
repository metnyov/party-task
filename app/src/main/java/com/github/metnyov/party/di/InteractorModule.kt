package com.github.metnyov.party.di

import com.github.metnyov.party.domain.interactor.GetPartyDetailsByIdUseCase
import com.github.metnyov.party.domain.interactor.GetPartyListUseCase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val interactorModule = DI.Module("interactor") {

    bind() from singleton { GetPartyListUseCase(instance()) }
    bind() from singleton { GetPartyDetailsByIdUseCase(instance()) }
}