package com.example.nycschoolsv2.model


import com.google.gson.annotations.SerializedName

data class SATScoresItem(
    @SerializedName("dbn")
    val dbn: String?,
    @SerializedName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String,
    @SerializedName("sat_math_avg_score")
    val satMathAvgScore: String,
    @SerializedName("sat_writing_avg_score")
    val satWritingAvgScore: String,
    @SerializedName("school_name")
    val schoolName: String
)