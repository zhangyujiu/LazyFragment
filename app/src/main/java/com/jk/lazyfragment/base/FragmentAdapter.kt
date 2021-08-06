package com.jk.lazyfragment.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(
    fm: FragmentManager,
    private val mFragmentList: List<Fragment>,
    private val mTitleList: List<String>
) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = mFragmentList.size

    override fun getItem(position: Int): Fragment = mFragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? {
        return if (mTitleList.size > position) {
            mTitleList[position]
        } else super.getPageTitle(position)
    }
}