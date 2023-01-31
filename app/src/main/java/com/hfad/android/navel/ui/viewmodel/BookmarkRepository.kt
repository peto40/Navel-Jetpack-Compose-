package com.hfad.android.navel.ui.viewmodel

import com.hfad.android.navel.data.database.DestinationCardState
import com.hfad.android.navel.data.database.NavelDao

class BookmarkRepository(private val navelDatabaseDao: NavelDao) {

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