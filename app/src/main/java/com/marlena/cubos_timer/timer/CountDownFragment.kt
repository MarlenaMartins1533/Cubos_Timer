package com.marlena.cubos_timer.timer

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlena.cubos_timer.R
import kotlinx.android.synthetic.main.fragment_count_down.*
import kotlinx.android.synthetic.main.fragment_timer.chronometer
import kotlinx.android.synthetic.main.fragment_timer.startBTN

class CountDownFragment : Fragment() {

    private var isRunning = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_count_down, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    @SuppressLint("NewApi")
    private fun initListener() {
        var startCountDown: Int

        startBTN.setOnClickListener {
            when (isRunning) {
                false -> {
                    startCountDown = getConvertedTime()
                    chronometer.base = SystemClock.elapsedRealtime() + startCountDown
                    chronometer.isCountDown = true
                    chronometer.start()
                    startBTN.setText(R.string.stop)
                    isRunning = true
                }
                true -> {
                    chronometer.stop()
                    startBTN.setText(R.string.start)
                    isRunning = false
                }
            }
        }
    }

    private fun getConvertedTime(): Int {
        return (getValueTimeEDT()*1000)
    }

    private fun getValueTimeEDT(): Int {

        var timeString = timeEDT?.text?.toString()
        if (timeString.isNullOrEmpty()) timeString = "59"
        return timeString.toInt()
    }

    companion object {
        fun newInstance(): CountDownFragment = CountDownFragment()
    }
}