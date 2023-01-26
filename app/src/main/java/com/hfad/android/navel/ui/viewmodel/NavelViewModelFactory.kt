package com.hfad.android.navel.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NavelViewModelFactory(
    private val application: Application
) : ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(NavelViewModel::class.java)) {
            return NavelViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}