package com.example.laboratorio05.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.PrimaryKey
import androidx.room.Relation

data class MovieWithActor(
    @Embedded val movie: MovieModel,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "actorId",
        associateBy = Junction(CastModel::class)
    )
    val actors: List<ActorModel>
)
