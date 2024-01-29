package com.example.rehber.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rehber.data.entity.Persones

@Database(entities = [Persones::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun getPersoneDao() : PersonroomDao


}