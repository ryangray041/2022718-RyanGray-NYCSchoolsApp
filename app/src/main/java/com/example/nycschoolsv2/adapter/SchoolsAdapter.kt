package com.example.nycschoolsv2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nycschoolsv2.databinding.SchoolItemBinding
import com.example.nycschoolsv2.model.SchoolsItem

class SchoolsAdapter(
    private val schoolsDataSet: List<SchoolsItem>,
    private val onSchoolClicked: (String) -> Unit
): RecyclerView.Adapter<SchoolsAdapter.SchoolsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolsViewHolder =
        SchoolsViewHolder(
            SchoolItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SchoolsViewHolder, position: Int) {
        holder.bind(schoolsDataSet[position])
    }

    override fun getItemCount(): Int = schoolsDataSet.size

    inner class SchoolsViewHolder(
        private val binding: SchoolItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(school: SchoolsItem) {
            binding.schoolName.text = school.schoolName
            binding.primaryAddressLine1.text = school.primaryAddressLine1
            binding.schoolEmail.text = school.schoolEmail
            binding.website.text = school.website

            itemView.setOnClickListener {
                onSchoolClicked(school.dbn)
            }
        }
    }

}
