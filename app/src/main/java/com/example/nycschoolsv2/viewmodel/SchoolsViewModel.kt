package com.example.nycschoolsv2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nycschoolsv2.model.SATScoresItem
import com.example.nycschoolsv2.network.ResultState
import com.example.nycschoolsv2.network.SchoolsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

/**
 *
 * The ViewModel is where I am handling all of my data.
 * I am retrieving the data from my repository then I update it using LiveData.
 * This allows for my view to uses the changes in the data
 *
 */

@HiltViewModel
class SchoolsViewModel @Inject constructor(
    private val schoolsRepository: SchoolsRepository,
    private val ioDispatcher: CoroutineDispatcher
): BaseViewModel() {

    private val _schools: MutableLiveData<ResultState> = MutableLiveData(ResultState.LOADING)
    val schools: LiveData<ResultState> get() = _schools

    private val _scores = MutableLiveData<List<SATScoresItem>>()
    val scores: LiveData<List<SATScoresItem>> get() = _scores

    private var schoolsJob: Job? = null

    fun getSchools() {
        schoolsJob = safeViewModelScope.launch(ioDispatcher) {
            schoolsRepository.getALLNYCSchools().collect() {
                _schools.postValue(it)
            }
        }
    }

    fun getSATScores(dbn: String) {
        schoolsJob = safeViewModelScope.launch(ioDispatcher) {
            schoolsRepository.getSATScores(dbn).collect() {
                _scores.postValue(it)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        schoolsJob?.cancel()
    }
}