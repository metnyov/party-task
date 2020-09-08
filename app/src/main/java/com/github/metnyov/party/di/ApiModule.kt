package com.github.metnyov.party.di

import android.content.Context
import com.github.metnyov.party.data.api.AppApi
import com.github.metnyov.party.data.api.MockAppApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val apiModule = DI.Module("api") {

    bind() from singleton {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    bind<AppApi>() with singleton {
        MockAppApi(instance(), instance<Context>().assets)
    }
}