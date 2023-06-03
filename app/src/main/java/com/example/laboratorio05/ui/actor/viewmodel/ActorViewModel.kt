package com.example.laboratorio05.ui.actor.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.MovieReviewerApplication
import com.example.laboratorio05.data.model.ActorModel
import com.example.laboratorio05.repositories.ActorRepository
import kotlinx.coroutines.launch

class ActorViewModel(private val repository: ActorRepository) : ViewModel() {
    var id = MutableLiveData(0)
    var name = MutableLiveData("")
    var status = MutableLiveData("")

    // TODO: complete getAllActors function
    suspend fun getAllActors() = repository.getAllActors()

    private fun addActor(actor: ActorModel){
        viewModelScope.launch {
            repository.addActors(actor)
        }
    }

    // TODO: Implement functions to validate data and save actors in the DB
    fun createActor() {
        if (!validateData()){
            status.value = WRONG_INFORMATION
            return
        }

        val actor = ActorModel(
            name = name.value!!
        )

        addActor(actor)
        clearData()
        status.value = ACTOR_CREATED

    }

    private fun validateData(): Boolean{
        when{
            name.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData(){
        id.value = 0
        name.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                ActorViewModel(app.actorRepository)
            }
        }

        const val ACTOR_CREATED = "Actor created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}