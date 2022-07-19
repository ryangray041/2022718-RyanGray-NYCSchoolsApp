package com.example.nycschoolsv2.model


import com.google.gson.annotations.SerializedName

data class SchoolsItem(
    @SerializedName("dbn")
    val dbn: String,
    @SerializedName("overview_paragraph")
    val overviewParagraph: String,
    @SerializedName("phone_number")
    val phoneNumber: String,
    @SerializedName("primary_address_line_1")
    val primaryAddressLine1: String,
    @SerializedName("school_email")
    val schoolEmail: String,
    @SerializedName("school_name")
    val schoolName: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("zip")
    val zip: String
)