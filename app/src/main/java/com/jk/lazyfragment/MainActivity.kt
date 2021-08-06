package com.jk.lazyfragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.jk.lazyfragment.base.FragmentAdapter
import com.jk.lazyfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this), null, false)
        setContentView(mBinding.root)
        mBinding.button1.setOnClickListener {
            startActivity(Intent(this, TestVpActivity::class.java))
        }
        mBinding.button2.setOnClickListener {
            startActivity(Intent(this, TestAddActivity::class.java))
        }
    }
}