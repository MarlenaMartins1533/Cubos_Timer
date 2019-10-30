package com.marlena.cubos_timer.scenes.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marlena.cubos_timer.R
import com.marlena.cubos_timer.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        tablayout.setupWithViewPager(viewPager)
        viewPager.adapter = MainPagerAdapter(supportFragmentManager)
    }

}
