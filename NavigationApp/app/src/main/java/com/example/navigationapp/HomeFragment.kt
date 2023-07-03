package com.example.navigationapp

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigationapp.databinding.FragmentHomeBinding
import org.w3c.dom.Text


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
//        return inflater.inflate(R.layout.fragment_home, container, false)

        // handle the click event on the button
        binding.btnSubmit.setOnClickListener {

            // check
            if (!TextUtils.isEmpty(binding.etName.text.toString())) {
                // passing data to other fragment
                val bundle = bundleOf("name" to binding.etName.text.toString())

                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            } else {
                Toast.makeText(activity, "Enter Your Name", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }

}