package com.example.laboratorio05

import android.app.Application
import com.example.laboratorio05.repositories.ActorRepository
import com.example.laboratorio05.repositories.CastRepository
import com.example.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication : Application() {
    // TODO: Create database instance

    // TODO: Create repositories instances
    val movieRepository: MovieRepository = TODO()
    val actorRepository: ActorRepository = TODO()
    val castRepository: CastRepository = TODO()
}