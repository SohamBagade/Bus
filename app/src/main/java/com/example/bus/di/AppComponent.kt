package com.example.bus.di

import com.ccpp.msw.di.ActivityBindingModule
import com.ccpp.msw.di.AppModule
import com.ccpp.shared.core.di.ViewModelModule
import com.ccpp.shared.network.NetworkModule
import com.example.bus.base.BaseApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Main component of the app, created and persisted in the Application class.
 *
 * Whenever a new module is created, it should be added to the list of modules.
 * [AndroidSupportInjectionModule] is the module from Dagger.Android that helps with the
 * generation and location of subcomponents.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetworkModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class
//        FailDialogModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>()
}
