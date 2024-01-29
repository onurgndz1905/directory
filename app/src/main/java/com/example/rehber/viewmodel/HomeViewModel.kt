package com.example.rehber.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rehber.data.entity.Persones
import com.example.rehber.repo.PersoneDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val krepo: PersoneDao) : ViewModel(){

    var personList = MutableLiveData<List<Persones>>()

    init {
        persondownload()
        personList = krepo.personegetir()
    }

    fun Personsearchview(searchword:String){
        krepo.Personsearch(searchword)
    }
    fun PersoneDelete(persone_id:Int){
       krepo.PersoneDelete(persone_id)
    }
    fun persondownload(){
        krepo.Personescome()
    }

}