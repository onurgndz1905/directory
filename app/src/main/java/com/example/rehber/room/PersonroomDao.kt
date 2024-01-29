package com.example.rehber.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.rehber.data.entity.Persones


@Dao
interface PersonroomDao {
    @Query("SELECT * FROM kisiler")
    suspend fun Personessss() : List<Persones>

    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%' || :searchword || '%'")
    suspend fun PersonSearch(searchword :String) : List<Persones>

    @Insert
    suspend fun PersoneAdd(persone:Persones)

    @Update
    suspend fun PersoneUpdate(persone:Persones)

    @Delete
    suspend fun PersoneDelete(persone: Persones)
}