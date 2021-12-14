package com.example.flowpodcast.di

import com.example.flowpodcast.view.FlowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel {  FlowViewModel() }

}