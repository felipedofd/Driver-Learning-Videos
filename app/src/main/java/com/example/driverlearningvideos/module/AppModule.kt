package com.example.driverlearningvideos.module

import com.example.driverlearningvideos.viewModel.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel {  ViewModel() }

}