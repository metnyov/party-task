package com.github.metnyov.party.presentation.common.args

import android.os.Parcelable

interface ArgsProvider<TArgs : Parcelable> {

    var args: TArgs
}