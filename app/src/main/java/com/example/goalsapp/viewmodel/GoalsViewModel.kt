package com.example.goalsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goalsapp.data.Goals
import com.example.goalsapp.model.Data

class GoalsViewModel : ViewModel() {
    private val _goalsData = MutableLiveData<MutableList<Data>>()
    val goalsData: LiveData<MutableList<Data>> get() = _goalsData

    private val data: MutableList<Data> = Goals().loadGoals()

    init {
        getGoalData()
    }

    private fun getGoalData() {
        _goalsData.value = data
    }

    fun addGoal(newGoal: Data) {
        val currentGoals = _goalsData.value ?: mutableListOf()
        currentGoals.add(0, newGoal)
        _goalsData.value = currentGoals
    }


}