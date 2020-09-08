package com.github.metnyov.party.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.metnyov.party.R
import com.github.metnyov.party.di.presentationModule
import moxy.MvpAppCompatActivity
import org.kodein.di.DIAware
import org.kodein.di.DITrigger
import org.kodein.di.android.closestDI
import org.kodein.di.android.retainedDI
import org.kodein.di.diContext
import org.kodein.di.instance
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : MvpAppCompatActivity(), DIAware {

    private val parentDI by closestDI()

    // Using retainedDI will not recreate DI when the Activity restarts
    override val di by retainedDI {
        extend(parentDI)
        import(presentationModule)
    }
    override val diContext = diContext<AppCompatActivity>(this)
    override val diTrigger = DITrigger()

    private val router: Router by instance()
    private val navigatorHolder: NavigatorHolder by instance()
    private val navigator = SupportAppNavigator(
        this,
        supportFragmentManager,
        R.id.mainActivityContainer
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_App_Base)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // TODO router.newRootScreen()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}