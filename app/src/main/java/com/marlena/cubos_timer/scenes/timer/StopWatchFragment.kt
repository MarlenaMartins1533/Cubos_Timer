package com.marlena.cubos_timer.scenes.timer

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marlena.cubos_timer.R
import kotlinx.android.synthetic.main.fragment_stop_watch.*
import kotlinx.android.synthetic.main.fragment_timer.chronometer
import kotlinx.android.synthetic.main.fragment_timer.startBTN

class StopWatchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stop_watch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener(){
        var isRunning = false
        var pause = 0L

        startBTN.setOnClickListener {
            if (!isRunning) {
                    chronometer.base = SystemClock.elapsedRealtime() - pause
                    chronometer.start()
                    isRunning = true
                }
            }
        resetBTN.setOnClickListener {
            chronometer.stop()
            chronometer.base = SystemClock.elapsedRealtime()
            pause = 0
            isRunning = false
        }

        stopBTN.setOnClickListener {
            chronometer.stop()
            pause = SystemClock.elapsedRealtime() - chronometer.base
            isRunning = false
        }
    }

    companion object {
        fun newInstance(): StopWatchFragment =
            StopWatchFragment()
    }
}
