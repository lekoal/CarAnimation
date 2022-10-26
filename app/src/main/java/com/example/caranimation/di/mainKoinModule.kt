package com.example.caranimation.di

import com.example.caranimation.ui.MainActivity
import com.example.caranimation.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainKoinModule = module {
    scope<MainActivity> {
        viewModel(named("main_view_model")) {
            MainActivityViewModel()
        }
    }
}