package com.jk.lazyfragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.jk.lazyfragment.base.FragmentAdapter
import com.jk.lazyfragment.databinding.ActivityTestVpBinding

class TestVpActivity : AppCompatActivity() {
    private val mFragments = arrayListOf(
        NestedFragment().apply { arguments = bundleOf("pageName" to "FragmentA") },
        FragmentB(),
        FragmentC(),
        NestedFragment().apply { arguments = bundleOf("pageName" to "FragmentD") }
    )
    private val mTitles = arrayListOf("页面一", "页面二", "页面三", "页面四")
    private lateinit var mBinding: ActivityTestVpBinding
    private lateinit var mAdapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTestVpBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(mBinding.root)
        mAdapter = FragmentAdapter(supportFragmentManager, mFragments, mTitles)
        mBinding.viewPager.adapter = mAdapter
        mBinding.viewPager.offscreenPageLimit = mFragments.size
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
    }
}