package com.example.nycschoolsv2.network

sealed class ResultState {
    object LOADING : ResultState()
    data class SUCCESS<T>(val response: List<T>): ResultState()
    data class ERROR(val e: Exception): ResultState()
}
