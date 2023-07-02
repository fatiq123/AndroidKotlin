package com.example.databindingwithobjects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingwithobjects.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // initialize the DataBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        // data binding for objects
        val user1: User = User(1, "Ali", "123")
        binding.user = user1


        // No need for this now
//        binding.apply {
//            tvUserId.text = user1.id.toString()
//            tvName.text = user1.name
//            tvPassword.text = user1.password
//        }

    }
}