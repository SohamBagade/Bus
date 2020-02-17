package com.example.bus.ui.home


import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.lifecycle.ViewModelProvider
import com.ccpp.shared.util.viewModelProvider

import com.example.bus.R
import com.example.bus.databinding.FragmentHomeBinding
import com.example.travelvoyage.base.BaseFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject
import kotlin.math.abs

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var fragmentViewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentViewModel = viewModelProvider(viewModelFactory)

        binding = FragmentHomeBinding.inflate(inflater,container,false).apply {
            viewModel = fragmentViewModel
            lifecycleOwner = this@HomeFragment

            calculate(appBarLayout)
        }

        return binding.root
    }

    private fun calculate(appBarLayout: AppBarLayout)
    {
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percentage = (abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange) * 100
            val alpha = 1 - (percentage / 100)
            var newAlpha = (alpha*10).toInt()

            var trans = (-appBarLayout.totalScrollRange - verticalOffset).toFloat()
            println(verticalOffset.toString())

            binding.collapseSearchContainer.collapsedContainer.translationY = (0 + verticalOffset).toFloat()



        })
    }

}
