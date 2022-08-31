package com.example.api

import org.json.JSONArray

data class Movie(
    val movieId : Int,
    val title : String,
    private val posterPath : String,
    val overview: String

    ) {
    //creates value that completes URL that was missing from posterPath val
    val posterImageURL = "https://image.tmdb.org/t/p/w500/$posterPath"

    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray) : List<Movie> {
            //list of Movies
            val movies = mutableListOf<Movie>()
            //populates movie list until information in array is met
            for(i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                //add movie
                movies.add(
                    //goes through each movie
                    Movie(
                        //gets the id, poster, title and overview from each movie in the array
                        movieJson.getInt("id"),
                        movieJson.getString("title"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("overview")
                    )
                )
            }
            //returns all the information just received from array back to movies
            return movies
        }
    }
}