package com.example.rehber.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.rehber.repo.PersoneDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonregistionViewModel @Inject constructor(val krepo: PersoneDao)  : ViewModel() {

    fun kayit(name_persone:String,number_persone:String){
        krepo.personekayit(name_persone,number_persone)
    }


}