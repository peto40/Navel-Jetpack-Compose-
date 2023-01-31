package com.hfad.android.navel.data.database

import androidx.room.*

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