package com.marlena.cubos_timer.scenes.timer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marlena.cubos_timer.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.marlena.cubos_timer.TimeZoneModel
import com.marlena.cubos_timer.adapter.TimeZoneRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_time_zone.*

class TimeZoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_time_zone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            TimeZoneModel(
                name = "Polinésia",
                timezone = "UTC-",
                time = 10
            ),
            TimeZoneModel(
                name = "Indonésia",
                timezone = "UTC+",
                time = 7
            ),
            TimeZoneModel(
                name = "China",
                timezone = "UTC+",
                time = 6
            )
        )

        val adapter = TimeZoneRecyclerAdapter(list)

        recyclerView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = adapter

        addMoreBTN?.setOnClickListener {
            adapter.addMoreItems(
                arrayListOf(
                    TimeZoneModel(
                        name = "China",
                        timezone = "UTC+",
                        time = 6
                    )
                )
            )
        }
    }

    companion object {
        fun newInstance(): TimeZoneFragment = TimeZoneFragment()
    }
}

