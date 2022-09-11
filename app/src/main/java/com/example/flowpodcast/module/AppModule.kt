package com.example.flowpodcast.module

import com.example.flowpodcast.viewModel.FlowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel {  FlowViewModel() }

}