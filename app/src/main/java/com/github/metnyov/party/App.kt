package com.github.metnyov.party

import android.app.Application
import com.github.metnyov.party.di.apiModule
import com.github.metnyov.party.di.interactorModule
import com.github.metnyov.party.di.sourceModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class App : Application(), DIAware {

    override val di: DI = DI.lazy {
        import(androidXModule(this@App))
        import(apiModule)
        import(sourceModule)
        import(interactorModule)
    }
}