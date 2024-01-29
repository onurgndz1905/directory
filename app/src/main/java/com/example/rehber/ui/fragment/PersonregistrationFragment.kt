package com.example.rehber.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.rehber.R
import com.example.rehber.databinding.FragmentHomeBinding
import com.example.rehber.databinding.FragmentPersonregistrationBinding
import com.example.rehber.viewmodel.HomeViewModel
import com.example.rehber.viewmodel.PersonDetailViewModel
import com.example.rehber.viewmodel.PersonregistionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class PersonregistrationFragment : Fragment() {

    private lateinit var personregisBinding: FragmentPersonregistrationBinding
    private lateinit var viewModel: PersonregistionViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        personregisBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_personregistration, container, false)

        personregisBinding.personRegister = this
        personregisBinding.personeregisterToolbarTitle = " Person Registration"



        return personregisBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonregistionViewModel by viewModels()
        viewModel = tempViewModel

    }


    fun buttonregestion(name_persone:String,number_persone:String){
        viewModel.kayit(name_persone,number_persone)
    }


}