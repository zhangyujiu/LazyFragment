package com.jk.lazyfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jk.lazyfragment.base.BaseLazyFragment
import com.jk.lazyfragment.databinding.FragmentTestBinding

class FragmentA : BaseLazyFragment() {
    private lateinit var mBinding: FragmentTestBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTestBinding.inflate(LayoutInflater.from(requireContext()), null, false)
        return mBinding.root
    }

    override fun onFragmentFirstVisible() {
        super.onFragmentFirstVisible()
        mBinding.textView.postDelayed({
            mBinding.textView.text = getPageTag()
        },2000)
    }
}