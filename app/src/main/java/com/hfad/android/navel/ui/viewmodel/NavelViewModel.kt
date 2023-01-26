package com.hfad.android.navel.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.hfad.android.navel.database.DestinationCardState
import com.hfad.android.navel.database.NavelDatabase
import com.hfad.android.navel.utils.NavelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NavelViewModel(application: Application) : AndroidViewModel(application) {

//    private var _uiState = MutableStateFlow(listOf( DestinationCardState()))
//    val uiState: StateFlow<List<DestinationCardState>> = _uiState.asStateFlow()


    val uiState: MutableLiveData<List<DestinationCardState>> by lazy {
        MutableLiveData<List<DestinationCardState>>()
    }

    private val repository: NavelRepository

    init {
        val navelDao = NavelDatabase.getInstance(application).getNavelDao()
        repository = NavelRepository(navelDao)

        loadAllCard(repository)
    }

    private fun loadAllCard(repository: NavelRepository) {
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