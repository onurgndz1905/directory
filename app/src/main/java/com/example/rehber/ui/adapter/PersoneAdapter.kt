package com.example.rehber.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.R
import androidx.recyclerview.widget.RecyclerView
import com.example.rehber.data.entity.Persones
import com.example.rehber.databinding.CardPersoneBinding
import com.example.rehber.ui.fragment.HomeFragmentDirections
import com.example.rehber.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar


class PersoneAdapter(var mcontex: Context,var personList: List<Persones> ,var viewModel: HomeViewModel)
    : RecyclerView.Adapter<PersoneAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:CardPersoneBinding):RecyclerView.ViewHolder(tasarim.root) {

        var tasarim : CardPersoneBinding = tasarim
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mcontex)

        val tasarim :CardPersoneBinding = DataBindingUtil.inflate(layoutInflater,com.example.rehber.R.layout.card_persone, parent,false)

        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {

        return personList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val persone = personList[position]

        holder.tasarim.personeartiycl = persone


        holder.tasarim.cardPersone.setOnClickListener {

            val navigation = HomeFragmentDirections.actionHomeFragmentToPersondetailFragment(persone)
            Navigation.findNavController(it).navigate(navigation)

        }

        holder.tasarim.imageViewdelete.setOnClickListener{
            Snackbar.make(it,"${persone.personeName} silinsin mi ?",Snackbar.LENGTH_LONG)

                .setAction("Evet"){
                    viewModel.PersoneDelete(persone.persone_id)
                }.show()

        }
    }
}


