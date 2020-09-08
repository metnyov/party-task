package com.github.metnyov.party.presentation.common.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import org.kodein.di.*
import org.kodein.di.android.x.di

abstract class BaseFragment<TPresenter : BasePresenter<*>> : MvpAppCompatFragment,
    BaseView, DIAware {

    abstract val presenter: TPresenter

    final override val di: DI by di()
    final override val diContext: DIContext<Fragment> = diContext(this)
    final override val diTrigger: DITrigger = DITrigger()

    constructor() : super()
    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        diTrigger.trigger()
    }
}