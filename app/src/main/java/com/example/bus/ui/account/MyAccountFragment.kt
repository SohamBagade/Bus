package com.example.bus.ui.home.account


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ccpp.shared.util.viewModelProvider
import com.example.bus.databinding.FragmentMyAccountBinding
import com.example.bus.ui.account.MyAccountViewModel
import com.example.travelvoyage.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MyAccountFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var fragmentViewModel: MyAccountViewModel

    private lateinit var binding: FragmentMyAccountBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        fragmentViewModel = viewModelProvider(viewModelFactory)

        binding =  FragmentMyAccountBinding.inflate(inflater, container, false).apply {

        }
        return binding.root
    }

}
