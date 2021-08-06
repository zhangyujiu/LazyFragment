package com.jk.lazyfragment

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.jk.lazyfragment.databinding.ActivityTestAddBinding

class TestAddActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityTestAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTestAddBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(mBinding.root)

        val fragmentA =
            supportFragmentManager.findFragmentByTag(FragmentA::class.java.simpleName)
                ?: FragmentA()
        val fragmentB =
            supportFragmentManager.findFragmentByTag(FragmentB::class.java.simpleName)
                ?: FragmentB()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.placeholder, fragmentA, FragmentA::class.java.simpleName)
            add(R.id.placeholder, fragmentB, FragmentB::class.java.simpleName)
            hide(fragmentB)
            commitAllowingStateLoss()
        }

        mBinding.button1.setOnClickListener {
            supportFragmentManager.beginTransaction().show(fragmentA).hide(fragmentB)
                .commitAllowingStateLoss()
        }

        mBinding.button2.setOnClickListener {
            supportFragmentManager.beginTransaction().show(fragmentB).hide(fragmentA)
                .commitAllowingStateLoss()
        }
    }
}