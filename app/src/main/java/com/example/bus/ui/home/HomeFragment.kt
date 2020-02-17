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
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject
import kotlin.math.abs
import kotlin.math.withSign


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
        var isShow = true
        var scrollRange = -1

        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val percentage = (abs(verticalOffset).toFloat() / appBarLayout.totalScrollRange) * 100
            val alpha = 1 - (percentage / 100)

            val new_range = appBarLayout.totalScrollRange/3
            val percentage1 = (abs(verticalOffset).toFloat() / new_range) * 100
            val alpha1 = 1 - (percentage1 / 100)

            binding.collapseSearchContainer.collapsedContainer.translationY = (0 + verticalOffset).toFloat()

            println(alpha)
            if(alpha<1f)
            {
                scaleView(binding.imageView,alpha1,alpha1)
            }

         //   searchscaleView(binding.imvSearch,alpha1,alpha1,alpha)

            if (scrollRange == -1)
            {
                scrollRange = appBarLayout.totalScrollRange
            }
            if (scrollRange + verticalOffset == 0)
            {
                isShow = true
//                binding.imvSearch.visibility = View.VISIBLE
//                binding.imageView.visibility = View.GONE
            }




        })
    }


    private fun scaleView(v: View, startScale: Float, endScale: Float) {

        if(startScale <0.0f)
        {
            return

        }else{
            val anim = ScaleAnimation(
                startScale, endScale, // Start and end values for the X axis scaling
                startScale, endScale, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f
            ) // Pivot point of Y scaling
            anim.fillAfter = true // Needed to keep the result of the animation
            anim.duration = 2000
            v.startAnimation(anim)

            binding.imageView.alpha = startScale
        }


    }


//    private fun searchscaleView(v: View, startScale: Float, endScale: Float, alpha : Float) {
//
//            if(alpha>0.3333f)
//            {
//                binding.imvSearch.visibility = View.GONE
//                return
//            }else{
//                binding.imvSearch.visibility = View.VISIBLE
//                val anim = ScaleAnimation(
//                    0.3f - startScale, 0.3f - endScale, // Start and end values for the X axis scaling
//                    0.3f- startScale, 0.3f- endScale, // Start and end values for the Y axis scaling
//                    Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
//                    Animation.RELATIVE_TO_SELF, 0.5f
//                ) // Pivot point of Y scaling
//                anim.fillAfter = true // Needed to keep the result of the animation
//                anim.duration = 2000
//                v.startAnimation(anim)
//
//                binding.imvSearch.alpha = 1f-startScale
//            }
//
//
//    }

}
