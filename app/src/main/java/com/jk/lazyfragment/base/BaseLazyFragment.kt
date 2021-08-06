package com.jk.lazyfragment.base

import android.util.Log

abstract class BaseLazyFragment : LogFragment() {
    private var mIsFirstVisible = true

    protected var isCurrentVisible = false

    private val isParentInvisible: Boolean
        get() {
            val parentFragment = parentFragment
            return if (parentFragment is BaseLazyFragment) {
                val fragment = parentFragment as BaseLazyFragment?
                !fragment!!.isCurrentVisible
            } else {
                false
            }
        }

    override fun onResume() {
        super.onResume()
        if (!isHidden && !isCurrentVisible) {
            dispatchUserVisibleHint(true)
        }
    }

    override fun onPause() {
        super.onPause()
        if (isCurrentVisible) {
            dispatchUserVisibleHint(false)
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            dispatchUserVisibleHint(false)
        } else {
            dispatchUserVisibleHint(true)
        }
    }

    private fun dispatchUserVisibleHint(visible: Boolean) {
        if (visible && isParentInvisible) return

        if (isCurrentVisible == visible) {
            return
        }

        isCurrentVisible = visible

        if (visible) {
            if (view == null) return
            if (mIsFirstVisible) {
                mIsFirstVisible = false
                onFragmentFirstVisible()
            }
            onFragmentResume()
        } else {
            if (!mIsFirstVisible) {
                onFragmentPause()
            }
        }
    }

    open fun onFragmentFirstVisible() {
        Log.d(getPageTag(), "onFragmentFirstVisible:")
    }

    open fun onFragmentResume() {
        Log.d(getPageTag(), "onFragmentResume:")
    }

    open fun onFragmentPause() {
        Log.d(getPageTag(), "onFragmentPause:")
    }
}