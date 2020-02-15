package com.example.bus.ui.home.booking


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ccpp.shared.util.viewModelProvider
import com.example.bus.databinding.FragmentMyBookingBinding
import com.example.bus.ui.booking.MyBookingViewModel
import com.example.travelvoyage.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MyBookingFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var fragmentViewModel: MyBookingViewModel

    private lateinit var binding: FragmentMyBookingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        fragmentViewModel = viewModelProvider(viewModelFactory)
        binding = FragmentMyBookingBinding.inflate(inflater, container, false).apply {
            viewModel = fragmentViewModel
            lifecycleOwner = this@MyBookingFragment
        }
        return binding.root
    }


}
