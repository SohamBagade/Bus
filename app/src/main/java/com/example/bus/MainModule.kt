package com.example.bus

import androidx.lifecycle.ViewModel
import com.ccpp.shared.core.di.FragmentScoped
import com.ccpp.shared.core.di.ViewModelKey
import com.example.bus.ui.account.MyAccountViewModel
import com.example.bus.ui.booking.MyBookingViewModel
import com.example.bus.ui.help.HelpFragment
import com.example.bus.ui.help.HelpViewModel
import com.example.bus.ui.home.HomeFragment
import com.example.bus.ui.home.HomeViewModel
import com.example.bus.ui.home.account.MyAccountFragment
import com.example.bus.ui.home.booking.MyBookingFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Module where classes needed to create the [MainFragment] are defined.
 */
@Module
internal abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment


    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMyBookingFragment(): MyBookingFragment

    @Binds
    @IntoMap
    @ViewModelKey(MyBookingViewModel::class)
    internal abstract fun bindMyBookingViewModel(viewModel: MyBookingViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeMyAccountFragment(): MyAccountFragment

    @Binds
    @IntoMap
    @ViewModelKey(MyAccountViewModel::class)
    internal abstract fun bindMyAccountViewModel(viewModel: MyAccountViewModel): ViewModel


    @FragmentScoped
    @ContributesAndroidInjector
    internal abstract fun contributeHelpFragment(): HelpFragment

    @Binds
    @IntoMap
    @ViewModelKey(HelpViewModel::class)
    internal abstract fun bindHelpViewModel(viewModel: HelpViewModel): ViewModel


}
