package com.marlena.cubos_timer.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.marlena.cubos_timer.scenes.timer.CountDownFragment
import com.marlena.cubos_timer.scenes.timer.StopWatchFragment
import com.marlena.cubos_timer.scenes.timer.TimeZoneFragment
import com.marlena.cubos_timer.scenes.timer.TimerFragment

class MainPagerAdapter(fm: FragmentManager):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    private val fragmentList = arrayListOf<Fragment>()
    private val titleList = arrayListOf<String>()

    init{
        titleList.add("Timer")
        titleList.add("Stopwatch")
        titleList.add("CountDown")
        titleList.add("Timezone")
        fragmentList.add(TimerFragment.newInstance())
        fragmentList.add(StopWatchFragment.newInstance())
        fragmentList.add(CountDownFragment.newInstance())
        fragmentList.add(TimeZoneFragment.newInstance())
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]
}