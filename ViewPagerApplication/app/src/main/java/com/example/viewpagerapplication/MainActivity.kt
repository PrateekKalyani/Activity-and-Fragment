package com.example.viewpagerapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import com.example.viewpagerapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding : ActivityMainBinding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        val adapter = ViewPagerAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        adapter.addFragment(FirstFragment(), "First1")
        adapter.addFragment(SecondFragment(), "Second2")
        adapter.addFragment(ThirdFragment(), "Third3")

        binding.viewPager.adapter = adapter
    }
}