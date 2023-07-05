package com.example.notetakingapp.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.notetakingapp.MainActivity
import com.example.notetakingapp.R
import com.example.notetakingapp.databinding.FragmentUpdateNoteBinding
import com.example.notetakingapp.model.Note
import com.example.notetakingapp.viewmodel.NoteViewModel


class UpdateNoteFragment : Fragment(R.layout.fragment_update_note) {

    private var _binding: FragmentUpdateNoteBinding? = null
    private val binding
        get() = _binding!!


    private lateinit var notesViewModel: NoteViewModel

    private lateinit var currentNote: Note

    // Since the Update_Note_Fragment contains the arguments in navigation_graph
    private val args: UpdateNoteFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesViewModel = (activity as MainActivity).noteViewModel

        currentNote = args.note!!



        binding.etUpdateNoteTitle.setText(currentNote.noteTitle)
        binding.etUpdateNoteBody.setText(currentNote.noteBody)


        // if the user update the note
        binding.fabDone.setOnClickListener {
            val title = binding.etUpdateNoteTitle.text.toString().trim()
            val body = binding.etUpdateNoteBody.text.toString().trim()

            if (title.isEmpty()) {
                val note = Note(currentNote.id, title, body)
                notesViewModel.updateNote(note = note)  // this will update the note
                view.findNavController().navigate(R.id.action_updateNoteFragment_to_homeFragment)
            } else {
                Toast.makeText(
                    view.context,
                    "Please enter note title",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


    }


    private fun deleteNote() {
        AlertDialog.Builder(activity).apply {

            setTitle("Delete Note")
            setMessage("Do you want to delete this Note?")
            setPositiveButton("Delete") { _, _ ->
                notesViewModel.deleteNote(currentNote)

                view?.findNavController()?.navigate(R.id.action_updateNoteFragment_to_homeFragment)
            }
            setNegativeButton("Cancel", null)
        }.create().show()
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()
        inflater.inflate(R.menu.menu_update_note, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // when user press on delete icon then it call the saveNote function and saves the record
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuDelete -> {
                deleteNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}