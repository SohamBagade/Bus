package com.example.bus.ui.help


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ccpp.shared.util.viewModelProvider
import com.example.bus.databinding.FragmentHelpBinding
import com.example.travelvoyage.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class HelpFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var fragmentViewModel: HelpViewModel

    private lateinit var binding: FragmentHelpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentViewModel = viewModelProvider(viewModelFactory)
        binding = FragmentHelpBinding.inflate(inflater, container, false).apply {
            viewModel = fragmentViewModel
            lifecycleOwner = this@HelpFragment
        }

        return binding.root
    }


}
