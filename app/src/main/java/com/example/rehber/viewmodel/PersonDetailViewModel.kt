package com.example.rehber.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.rehber.repo.PersoneDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(val krepo: PersoneDao)   : ViewModel() {


    fun buttondaoupdate(persone_id:Int, name_persone:String,persone_number:String){
      krepo.buttondaoupdate(persone_id,name_persone,persone_number)
    }


}