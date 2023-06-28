package com.example.worldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.worldcupapp.R.id.listView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 1. Adapter View : ListView
        val listView: ListView = findViewById(R.id.listView)


        // 2. Data Source
        fun generateData(): ArrayList<CountryModel> {

            val countriesList = ArrayList<CountryModel>()

            val country1 = CountryModel(
                // i myself provide them as a default parameters like name = "Brazil i can also pass as "Brazil".
                name = "Brazil",
                cupWins = "Wins: 5",
                flagImg = R.drawable.brazil
            )
            val country2 = CountryModel(
                // i myself provide them as a default parameters like name = "Brazil i can also pass as "Brazil".
                name = "England",
                cupWins = "Wins: 4",
                flagImg = R.drawable.unitedkingdom
            )
            val country3 = CountryModel(
                // i myself provide them as a default parameters like name = "Brazil i can also pass as "Brazil".
                name = "France",
                cupWins = "Wins: 4",
                flagImg = R.drawable.france
            )
            val country4 = CountryModel(
                // i myself provide them as a default parameters like name = "Brazil i can also pass as "Brazil".
                name = "Germany",
                cupWins = "Wins: 3",
                flagImg = R.drawable.germany
            )
            val country5 = CountryModel(
                // i myself provide them as a default parameters like name = "Brazil i can also pass as "Brazil".
                name = "Spain",
                cupWins = "Wins: 3",
                flagImg = R.drawable.spain
            )
            val country6 = CountryModel(
                // i myself provide them as a default parameters like name = "Brazil i can also pass as "Brazil".
                name = "United States",
                cupWins = "Wins: 1",
                flagImg = R.drawable.unitedstates
            )
            val country7 = CountryModel(
                // i myself provide them as a default parameters like name = "Brazil i can also pass as "Brazil".
                name = "Saudi Arabia",
                cupWins = "Wins: 0",
                flagImg = R.drawable.saudiarabia
            )


            countriesList.add(country1)
            countriesList.add(country2)
            countriesList.add(country3)
            countriesList.add(country4)
            countriesList.add(country5)
            countriesList.add(country6)
            countriesList.add(country7)

            return countriesList
        }


        // 3. Adapter
        val adapter = MyAdapter(this, generateData())


        // now combine the listView(it is the id for listView) and Adapter
        listView.adapter = adapter
        listView.deferNotifyDataSetChanged()
    }
}