package com.example.segundo_parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Peliculas_Impar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_peliculas_impar)

        val moviesImpar = ArrayList<Id_Impar>()
        val titles: Array<String> = resources.getStringArray(R.array.title)
        val metascores: Array<String> = resources.getStringArray(R.array.metascore)
        val imdbRatings: Array<String> = resources.getStringArray(R.array.imdbRating)
        val imdbVotes: Array<String> = resources.getStringArray(R.array.imdbVotes)

        for((i, element) in titles.withIndex()){
            val movie = Id_Impar()
            movie.title = element
            movie.metascore = metascores[i]
            movie.imdbRating = imdbRatings[i]
            movie.imdbVotes = imdbVotes[i]
            moviesImpar.add(movie)
        }

    }
}