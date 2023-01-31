package com.hfad.android.navel.ui.viewmodel

import android.content.Context
import androidx.lifecycle.*
import com.hfad.android.navel.data.database.DestinationCardState
import com.hfad.android.navel.data.database.NavelDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookmarkViewModel(context: Context) : ViewModel() {

    val uiState: MutableLiveData<List<DestinationCardState>> by lazy {
        MutableLiveData<List<DestinationCardState>>()
    }

    private val repository: BookmarkRepository

    init {
        val navelDao = NavelDatabase.getInstance(context = context).getNavelDao()
        repository = BookmarkRepository(navelDao)

        loadAllCard(repository)
    }

    private fun loadAllCard(repository: BookmarkRepository) {
        viewModelScope.launch(Dispatchers.Main) {
            uiState.value = repository.getAllData()
        }
    }

    fun addCard(cardItem: DestinationCardState) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCard(cardItem)
        }
    }

    fun deleteCard(cardItem: DestinationCardState) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCard(cardItem)
        }
    }

}