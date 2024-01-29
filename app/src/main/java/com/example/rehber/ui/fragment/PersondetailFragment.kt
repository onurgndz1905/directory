package com.example.rehber.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.rehber.R
import com.example.rehber.databinding.FragmentPersondetailBinding
import com.example.rehber.databinding.FragmentPersonregistrationBinding
import com.example.rehber.viewmodel.HomeViewModel
import com.example.rehber.viewmodel.PersonDetailViewModel
import com.example.rehber.viewmodel.PersonregistionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class PersondetailFragment : Fragment() {
    private lateinit var persondetailBinding: FragmentPersondetailBinding
    private lateinit var viewModel: PersonDetailViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        persondetailBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_persondetail , container, false)
        persondetailBinding.persondetailFragment = this
        persondetailBinding.persondetailToolbarTitle = "Persone Detail"

        val bundle: PersondetailFragmentArgs by navArgs()

        val icomingpersone =bundle.Persone

       persondetailBinding.personarticle = icomingpersone
        persondetailBinding.buttonupdate.setOnClickListener{
            val name_persone =  persondetailBinding.editTextpersonupdatename.text.toString()
            val number_persone =  persondetailBinding.ediTextupdatepersonenumber.text.toString()

            buttonupdate(icomingpersone.persone_id,name_persone,number_persone)

        }

        return persondetailBinding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : PersonDetailViewModel by viewModels()
        viewModel = tempViewModel

    }

    fun buttonupdate(persone_id:Int, name_persone:String,persone_number:String){
        viewModel.buttondaoupdate(persone_id,name_persone,persone_number)
    }

}