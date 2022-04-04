package com.hur.milkpurification.koin.module

import com.hur.milkpurification.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by jforjari@gmail.com .
 * Email: ingenious.hur@gmail.com
 */
val ViewModelModule = module {

    /**
     * The viewModel keyword helps declaring a factory instance of ViewModel. [MainViewModel]
     * This instance will be handled by internal ViewModelFactory
     * and reattach [MainViewModel] ViewModel instance if needed.
     */
    viewModel {
        MainViewModel()
    }
}