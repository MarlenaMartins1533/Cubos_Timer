package com.marlena.cubos_timer.scenes.timer

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlena.cubos_timer.R
import kotlinx.android.synthetic.main.fragment_timer.*

class TimerFragment: Fragment(){

    private var isRunning = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        startBTN.setOnClickListener {
            when (isRunning) {
                false -> {
                    chronometer.base = SystemClock.elapsedRealtime()
                    chronometer.start()
                    isRunning = true
                    startBTN.setText(R.string.stop)
                }
                true -> {
                    chronometer.stop()
                    isRunning = false
                    startBTN.setText(R.string.start)
                }
            }
        }
    }

    companion object {
        fun newInstance(): TimerFragment = TimerFragment()
    }
}