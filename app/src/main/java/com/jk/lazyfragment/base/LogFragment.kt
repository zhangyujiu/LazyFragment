package com.jk.lazyfragment.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class LogFragment : Fragment() {
    protected val TAG = javaClass.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(getPageTag(), "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(getPageTag(), "onCreate: ")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(getPageTag(), "onViewCreated: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(getPageTag(), "onCreateView: ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(getPageTag(), "onActivityCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(getPageTag(), "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(getPageTag(), "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(getPageTag(), "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(getPageTag(), "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(getPageTag(), "onDestroyView: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(getPageTag(), "onDetach: ")
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        Log.d(getPageTag(), "onHiddenChanged:hidden-->$hidden")
    }

    fun getPageTag(): String {
        val pageName = arguments?.getString("pageName") ?: ""
        return if (pageName.isNotEmpty()) pageName else TAG
    }
}