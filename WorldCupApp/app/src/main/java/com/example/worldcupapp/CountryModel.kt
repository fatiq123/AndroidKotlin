package com.example.worldcupapp

class CountryModel {

    var name: String = ""
    var cupWins: String = ""
    var flagImg: Int = 0    // we represent ImageView as Integer  while TextView as String


    constructor(name: String, cupWins: String, flagImg: Int) {
        this.name = name
        this.cupWins = cupWins
        this.flagImg = flagImg
    }
}