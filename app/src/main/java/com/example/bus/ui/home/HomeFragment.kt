package com.example.bus.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ccpp.shared.util.viewModelProvider
import com.example.bus.databinding.FragmentHomeBinding
import com.example.travelvoyage.base.BaseFragment
import com.google.android.material.appbar.AppBarLayout
import javax.inject.Inject
import kotlin.math.abs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bus.ui.home.adapter.BookingAdapter


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var fragmentViewModel: HomeViewModel

    private lateinit var binding: FragmentHomeBinding

    private lateinit var adapter: BookingAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentViewModel = viewModelProvider(viewModelFactory)

        binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            viewModel = fragmentViewModel
            lifecycleOwner = this@HomeFragment

            bookRecyclerView.layoutManager = GridLayoutManager(context, 3)
            adapter = BookingAdapter(fragmentViewModel.getBookArrayList())
            bookRecyclerView.adapter = adapter

            calculate(appBarLayout)
        }

        return binding.root
    }

    private fun calculate(appBarLayout: AppBarLayout) {

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percentage = (abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange) * 100
            val alpha = 1 - (percentage / 100)

            val new_range = appBarLayout.totalScrollRange / 3
            val percentage1 = (abs(verticalOffset).toFloat() / new_range) * 100
            val alpha1 = 1 - (percentage1 / 100)

            binding.collapseSearchContainer.collapsedContainer.translationY =
                (0 + verticalOffset).toFloat()

            if (alpha < 1f) {
                scaleView(binding.imageView, alpha1, alpha1)
            }else if(alpha<0.66f)
            {
                if(binding.tvSource.text.isNullOrEmpty())
                binding.tvSource.hint = "Source,Destination"
                else
                    binding.tvSource.text = binding.tvSource.text.toString()+","+binding.collapseSearchContainer.tvDestination.text
            }

            if (alpha < 0.33f) {
                searchscaleView(binding.imvSearch, alpha1, verticalOffset)
            }else{
                binding.imvSearch.visibility = View.GONE
            }
        })
    }


    private fun scaleView(v: View, startScale: Float, endScale: Float) {

        if (startScale < 0.0f) {
            return

        } else {
            val anim = ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f
            ) // Pivot point of Y scaling
            anim.fillAfter = true // Needed to keep the result of the animation
            anim.duration = 100
            v.startAnimation(anim)

            binding.imageView.alpha = startScale
            binding.collapseSearchContainer.imvDestinationBus.alpha = startScale
            binding.collapseSearchContainer.tvDestination.animate().alpha(startScale).duration = 100

        }


    }

    private fun searchscaleView(v: View, startScale: Float, endScale: Int) {
        val cons = (1f - (startScale * -1)) * -1

        if (cons < 0.0f) {
            return
        } else {
            binding.imvSearch.visibility = View.VISIBLE
            val anim = ScaleAnimation(
                cons, cons, // Start and end values for the X axis scaling
                cons, cons, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f
            ) // Pivot point of Y scaling
            anim.fillAfter = true // Needed to keep the result of the animation
            anim.duration = 100
            v.startAnimation(anim)

            binding.imvSearch.alpha = cons
        }
    }

}
