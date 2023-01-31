package com.hfad.android.navel.ui.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BookmarkViewModelFactory(
    private val context: Context
) : ViewModelProvider.AndroidViewModelFactory(context as Application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(BookmarkViewModel::class.java)) {
            return BookmarkViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}