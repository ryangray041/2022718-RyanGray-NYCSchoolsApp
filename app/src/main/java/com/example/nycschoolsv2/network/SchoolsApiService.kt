package com.example.nycschoolsv2.network

import com.example.nycschoolsv2.model.SATScoresItem
import com.example.nycschoolsv2.model.SchoolsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolsApiService {

    @GET(SCHOOLS_PATH)
    suspend fun getAllNYCSchools(): Response<List<SchoolsItem>>

    @GET(SAT_SCORES_PATH)
    suspend fun getSATScores(
        @Query("dbn") dbn: String
    ): Response<List<SATScoresItem>>

    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us/resource/"

        private const val SCHOOLS_PATH = "s3k6-pzi2.json"
        private const val SAT_SCORES_PATH = "f9bf-2cp4.json"
    }
}