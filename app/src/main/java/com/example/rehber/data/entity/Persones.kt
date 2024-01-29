package com.example.rehber.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "kisiler")
data class Persones(@PrimaryKey(autoGenerate = true)
             @ColumnInfo(name = "kisi_id") val persone_id:Int,
             @ColumnInfo(name = "kisi_ad") val personeName:String,
             @ColumnInfo(name = "kisi_tel") val personeNumber:String) :Serializable {
}