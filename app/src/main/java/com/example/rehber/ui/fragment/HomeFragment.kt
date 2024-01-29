package com.example.rehber.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rehber.R
import com.example.rehber.data.entity.Persones
import com.example.rehber.databinding.FragmentHomeBinding
import com.example.rehber.ui.adapter.PersoneAdapter
import com.example.rehber.viewmodel.HomeViewModel
import com.example.rehber.viewmodel.PersonregistionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeBinding =  DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        homeBinding.homeFragment = this

        homeBinding.homeToolbartitle = "Persons"

        (activity as AppCompatActivity).setSupportActionBar(homeBinding.toolbarhome)

        viewModel.personList.observe(viewLifecycleOwner){
            val adapter = PersoneAdapter(requireContext(),it,viewModel)
            homeBinding.personeAdapter =adapter
        }


        homeBinding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_personregistrationFragment)

        }
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
               menuInflater.inflate(R.menu.toolbarmenu,menu)

                val item = menu.findItem(R.id.actionsearch)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)

            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)

        return homeBinding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels()
        viewModel = tempViewModel

    }

    // Arama fonksyionları
    override fun onQueryTextSubmit(query: String): Boolean {
       viewModel.Personsearchview(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.Personsearchview(newText)
        return true
    }




    fun fabclick(it:View){
        Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_personregistrationFragment)
    }

    override fun onResume() {
        super.onResume()
        viewModel.persondownload()


    }



}