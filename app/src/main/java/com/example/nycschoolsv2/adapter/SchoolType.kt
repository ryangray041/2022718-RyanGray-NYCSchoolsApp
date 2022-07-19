package com.example.nycschoolsv2.adapter

import com.example.nycschoolsv2.model.SchoolsItem

sealed class SchoolType {
    data class School(val schoolsItem: SchoolsItem): SchoolType()
}
