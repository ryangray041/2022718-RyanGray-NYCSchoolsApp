package com.example.nycschoolsv2.network

import com.example.nycschoolsv2.model.SATScoresItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface SchoolsRepository {
    fun getALLNYCSchools(): Flow<ResultState>
    fun getSATScores(dbn: String): Flow<List<SATScoresItem>>
}

class SchoolsRepositoryImpl @Inject constructor(
    private val service: SchoolsApiService
) : SchoolsRepository {

    override fun getALLNYCSchools(): Flow<ResultState> =
        flow {
            emit(ResultState.LOADING)
            try {
                val response = service.getAllNYCSchools()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ResultState.SUCCESS(it))
                    } ?: throw Exception ("BODY RESPONSE IS NULL")
                } else {
                    throw Exception(response.errorBody()?.toString())
                }
            } catch (e: Exception) {
                emit(ResultState.ERROR(e))
            }
        }

    override fun getSATScores(dbn: String): Flow<List<SATScoresItem>> =
        flow {
            //emit(ResultState.LOADING)
            try {
                val response = service.getSATScores(dbn)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit((it))
                    } ?: throw Exception ("BODY RESPONSE IS NULL")
                } else {
                    throw Exception(response.errorBody()?.toString())
                }
            } catch (e: Exception) {
                emit(throw e)
            }
        }
}