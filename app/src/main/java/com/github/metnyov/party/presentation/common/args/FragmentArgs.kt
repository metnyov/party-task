package com.github.metnyov.party.presentation.common.args

import android.os.Parcelable
import com.github.metnyov.party.presentation.common.base.BaseFragmentWithArgs

@Suppress("unused")
abstract class FragmentArgs<TFragment : BaseFragmentWithArgs<*, *>> : Parcelable