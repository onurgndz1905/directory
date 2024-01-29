package com.example.rehber.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.rehber.data.entity.Persones
import com.example.rehber.room.PersonroomDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersoneDao (var pdao:PersonroomDao) {

    lateinit var personesList:MutableLiveData<List<Persones>>
    init {
        personesList = MutableLiveData()
    }
    fun personegetir() : MutableLiveData<List<Persones>> {
        return personesList
    }

    fun personekayit(name_persone:String,number_persone:String){
        val job = CoroutineScope(Dispatchers.Main).launch(){
            val newpersone = Persones(0, name_persone,number_persone)
            pdao.PersoneAdd(newpersone)
        }
    }
    fun buttondaoupdate(persone_id:Int, name_persone:String,persone_number:String){
        val job = CoroutineScope(Dispatchers.Main).launch(){
            val updatepersone = Persones(persone_id, name_persone,persone_number)
            pdao.PersoneUpdate(updatepersone)
        }
    }

    fun Personsearch(searchword:String){
        val job = CoroutineScope(Dispatchers.Main).launch(){
            personesList.value = pdao.PersonSearch(searchword)
        }
    }
    fun PersoneDelete(persone_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch(){
            val deletepersone = Persones(persone_id, "","")
            pdao.PersoneDelete(deletepersone)
            Personescome()
        }
    }

    fun Personescome(){
        val job = CoroutineScope(Dispatchers.Main).launch(){
            personesList.value = pdao.Personessss()
        }
    }

}