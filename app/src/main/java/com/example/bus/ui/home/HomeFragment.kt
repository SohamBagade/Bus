package com.example.bus.ui.home


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout

import com.example.bus.R
import com.example.travelvoyage.base.BaseFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.math.abs

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var layoutDestination: RelativeLayout
    private lateinit var collapsed_container: RelativeLayout
    private lateinit var layoutSourceDivider: View
    private lateinit var layoutDestinationDivider: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        appBarLayout = view.findViewById(R.id.appBarLayout)
        layoutDestination = view.findViewById(R.id.layoutDestination)
        collapsed_container = view.findViewById(R.id.collapsed_container)
        layoutSourceDivider = view.findViewById(R.id.layoutSourceDivider)
        layoutDestinationDivider = view.findViewById(R.id.layoutDestinationDivider)
        claculate(appBarLayout)
        return view
    }

    private fun claculate(appBarLayout: AppBarLayout)
    {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            var percentage = (abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange) * 100
            var alpha = 1 - (percentage / 100)
            var newAlpha = (alpha*10).toInt()

            var trans = (-appBarLayout.totalScrollRange - verticalOffset).toFloat()
            println(verticalOffset.toString())

            collapsed_container.translationY = (0 + verticalOffset).toFloat()
           // layoutDestination.alpha =  1 - verticalOffset/appBarLayout.height
           // layoutDestinationDivider.translationY = (0 + verticalOffset).toFloat()



        })
    }

}
