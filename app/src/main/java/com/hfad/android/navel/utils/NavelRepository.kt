package com.hfad.android.navel.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hfad.android.navel.database.DestinationCardState
import com.hfad.android.navel.database.NavelDao

class NavelRepository(private val navelDatabaseDao: NavelDao) {

    suspend fun getAllData(): List<DestinationCardState> {
        return navelDatabaseDao.getAll()
    }

    suspend fun addCard(card: DestinationCardState) {
        navelDatabaseDao.insert(card)
    }

    suspend fun deleteCard(card: DestinationCardState) {
        navelDatabaseDao.delete(card)
    }


}