package com.example.nycschoolsv2.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.plus

private const val TAG = "SchoolsViewModel"

open class BaseViewModel: ViewModel() {

    protected val safeViewModelScope by lazy {
        viewModelScope + CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.e(TAG, "getSchools: Unhandled Exception: ${throwable.localizedMessage}", throwable)
        }
    }

}