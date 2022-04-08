package com.example.segundo_parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Peliculas_Par : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas_par)

        val moviesPar = ArrayList<Id_Par>()
        val titles: Array<String> = resources.getStringArray(R.array.title)
        val years: Array<String> = resources.getStringArray(R.array.year)
        val directors: Array<String> = resources.getStringArray(R.array.director)
        val languages: Array<String> = resources.getStringArray(R.array.language)

        for((i, element) in titles.withIndex()){
            val movie = Id_Par()
            movie.title = element
            movie.year = years[i]
            movie.director = directors[i]
            movie.language = languages[i]
            moviesPar.add(movie)
        }
    }
}