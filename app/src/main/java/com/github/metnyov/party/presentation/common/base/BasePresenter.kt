package com.github.metnyov.party.presentation.common.base

import moxy.MvpPresenter

abstract class BasePresenter<TView : BaseView> : MvpPresenter<TView>()