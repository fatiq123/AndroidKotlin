package com.example.navigationapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.navigationapp.databinding.FragmentHomeBinding
import com.example.navigationapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {


    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
//        return inflater.inflate(R.layout.fragment_home, container, false)

        // to get data from first activity
        val input = arguments?.getString("name")
        binding.textView2.text = input.toString()



        return binding.root
    }

}