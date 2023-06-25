package com.example.luckynumberapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName: EditText = findViewById(R.id.etEnterName)
        val btnLuck: Button = findViewById(R.id.btnLuck)

        btnLuck.setOnClickListener {

            val name = etName.text.toString()

            val i: Intent = Intent(this,LuckyNumberActivity::class.java).also {
                it.putExtra("EXTRA_NAME",name)

                startActivity(it)
            }
            // or we can also do this if we do not add .also(scope function)
//            i.putExtra("EXTRA_NAME",name)
//            startActivity(i)
        }
    }
}