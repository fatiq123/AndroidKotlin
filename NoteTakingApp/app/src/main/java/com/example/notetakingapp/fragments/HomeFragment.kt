package com.example.notetakingapp.fragments

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.notetakingapp.MainActivity
import com.example.notetakingapp.R
import com.example.notetakingapp.adapter.NoteAdapter
import com.example.notetakingapp.databinding.FragmentHomeBinding
import com.example.notetakingapp.viewmodel.NoteViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class HomeFragment : Fragment(R.layout.fragment_home), SearchView.OnQueryTextListener {


    //The usage of the getter method for accessing the binding object is primarily related to the convenience
    //and safety of working with view bindings. It helps avoid nullability-related issues and provides a concise way to access the binding object.

    //The getter method for accessing the binding object, as shown in the code snippet _binding!!,
    // is typically used when working with view bindings in Android Fragments or Activities.
    //It helps ensure that the binding object is non-null and simplifies accessing it throughout the code.
    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = _binding!!


    private lateinit var notesViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesViewModel =
            (activity as MainActivity).noteViewModel       // it refers to noteViewModel variable in mainActivity

        setUpRecyclerView()

        // just click on fabButton and it infers to new Fragment which is homeFragment
        binding.fabAddNote.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_newNoteFragment)
        }
    }

    private fun setUpRecyclerView() {
        noteAdapter = NoteAdapter()     // initialize the noteAdapter from the class

        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                2,
                GridLayoutManager.VERTICAL
            )
            setHasFixedSize(true)
            adapter = noteAdapter
        }


        activity?.let {
            notesViewModel.getAllNotes().observe(
                viewLifecycleOwner, { note ->
                    noteAdapter.differ.submitList(note)
                    updateUI(note)
                }
            )
        }

    }

    private fun updateUI(note: List<Note?>) {
        if (note.isEmpty()) {
            binding.cardView.visibility = View.GONE
            binding.recyclerView.visibility = View.VISIBLE
        } else {
            binding.cardView.visibility = View.VISIBLE
            binding.recyclerView.visibility = View.GONE
        }
    }

    // this function is used for menus specially
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        menu.clear()

        inflater.inflate(R.menu.home_menu, menu)

        // when user search the record or pass any query in search box
        val mMenuSearch = menu.findItem(R.id.menu_search).actionView as SearchView
        mMenuSearch.isSubmitButtonEnabled = false
        mMenuSearch.setOnQueryTextListener(this)

    }
    override fun onQueryTextSubmit(query: String?): Boolean {

        searchNote(query)
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {

        if (newText != null){
            searchNote(newText)
        }
        return true
    }

    private fun searchNote(query: String?) {

        val searchQuery = "%$query"
        notesViewModel.searchNote(searchQuery).observe(
            this,
            {
                list -> noteAdapter.differ.submitList(list)
            }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}