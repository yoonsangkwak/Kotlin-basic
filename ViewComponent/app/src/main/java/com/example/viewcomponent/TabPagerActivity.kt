package com.example.viewcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, 3)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        // 페이저가 이동했을 때 탭을 이동시키는 코드
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
    }
}

class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
): FragmentStatePagerAdapter(fragmentManager) {
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return Fragment1()
            }
            1 -> {
                return Fragment2()
            }
            2 -> {
                return Fragment3()
            }
            else -> return Fragment1()
        }
    }
}