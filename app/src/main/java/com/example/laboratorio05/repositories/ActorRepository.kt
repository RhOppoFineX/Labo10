package com.example.laboratorio05.repositories

import com.example.laboratorio05.data.dao.ActorDao
import com.example.laboratorio05.data.model.ActorModel

class ActorRepository(private val moviesActorDao: ActorDao) {
        // TODO: complete Actor ActorRepository
        suspend fun getActors() = moviesActorDao.getAllActors()

        suspend fun addActors(actor: ActorModel) = moviesActorDao.insertActor(actor)

}