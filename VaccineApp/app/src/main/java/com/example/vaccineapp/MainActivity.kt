package com.example.vaccineapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Like ListView Project(WorldCupAPP) we always have 3 steps.


        // 1. AdapterView: RecyclerView in this case but in case of listView it is of type ListView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this,      // this line is must in order to display recyclerView in vertical or horizontal manner
            LinearLayoutManager.VERTICAL,
            false
        )


        // 2. Data Source: List of VaccineModel Objects
        val vaccinesList: ArrayList<VaccineModel> = ArrayList()

        val vaccine1 = VaccineModel("COVID-19", R.drawable.vaccine1)
        val vaccine2 = VaccineModel("Hepatitis B Vaccine", R.drawable.vaccine4)
        val vaccine3 = VaccineModel("Tetanus Vaccine", R.drawable.vaccine5)
        val vaccine4 = VaccineModel("Pneumonia Vaccine", R.drawable.vaccine6)
        val vaccine5 = VaccineModel("Rotavirus Vaccine", R.drawable.vaccine7)
        val vaccine6 = VaccineModel("Measles Vaccine", R.drawable.vaccine8)
        val vaccine7 = VaccineModel("Chickenpox Vaccine", R.drawable.vaccine9)

        vaccinesList.add(vaccine1)
        vaccinesList.add(vaccine2)
        vaccinesList.add(vaccine3)
        vaccinesList.add(vaccine4)
        vaccinesList.add(vaccine5)
        vaccinesList.add(vaccine6)
        vaccinesList.add(vaccine7)


        // 3. Adapter it is used to connect the AdapterView and Data Source
        val adapter = MyAdapter(vaccinesList)
        recyclerView.adapter = adapter
    }
}