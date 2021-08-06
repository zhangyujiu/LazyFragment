package com.jk.lazyfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.jk.lazyfragment.base.BaseLazyFragment
import com.jk.lazyfragment.base.FragmentAdapter
import com.jk.lazyfragment.databinding.ActivityTestVpBinding

class NestedFragment : BaseLazyFragment() {
    private val mFragments = arrayListOf(
        FragmentA().apply { arguments = bundleOf("pageName" to "NestedFragment1") },
        FragmentB().apply { arguments = bundleOf("pageName" to "NestedFragment2") },
        FragmentC().apply { arguments = bundleOf("pageName" to "NestedFragment3") },
        FragmentD().apply { arguments = bundleOf("pageName" to "NestedFragment4") }
    )
    private val mTitles = arrayListOf("Nested1", "Nested2", "Nested3", "Nested4")
    private lateinit var mBinding: ActivityTestVpBinding
    private lateinit var mAdapter: FragmentAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = ActivityTestVpBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        return mBinding.root
    }

    override fun onFragmentFirstVisible() {
        super.onFragmentFirstVisible()
        mAdapter = FragmentAdapter(childFragmentManager, mFragments, mTitles)
        mBinding.viewPager.adapter = mAdapter
        mBinding.viewPager.offscreenPageLimit = mFragments.size
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
    }
}