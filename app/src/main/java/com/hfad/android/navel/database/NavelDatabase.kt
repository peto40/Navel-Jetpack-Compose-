package com.hfad.android.navel.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DestinationCardState::class], version = 2, exportSchema = false)
abstract class NavelDatabase : RoomDatabase() {
    abstract fun getNavelDao(): NavelDao

    companion object {

        private var INSTANCE: NavelDatabase? = null

        fun getInstance(context: Context): NavelDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NavelDatabase::class.java,
                        "navel_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}