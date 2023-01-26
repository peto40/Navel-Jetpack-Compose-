package com.hfad.android.navel.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Dao
interface NavelDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(card: DestinationCardState)

    @Update
    suspend fun update(card: DestinationCardState)

    @Delete
    suspend fun delete(card: DestinationCardState)

    @Query("Select * from destCardTable order by id ASC")
    suspend fun getAll() : List<DestinationCardState>
}