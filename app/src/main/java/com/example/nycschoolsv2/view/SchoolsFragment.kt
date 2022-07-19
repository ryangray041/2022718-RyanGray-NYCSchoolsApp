package com.example.nycschoolsv2.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nycschoolsv2.R
import com.example.nycschoolsv2.adapter.SchoolsAdapter
import com.example.nycschoolsv2.databinding.FragmentSchoolsBinding
import com.example.nycschoolsv2.model.SchoolsItem
import com.example.nycschoolsv2.network.ResultState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SchoolsFragment : BaseFragment() {

    private val binding by lazy {
        FragmentSchoolsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        schoolViewModel.schools.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ResultState.LOADING -> {
                    Log.d("HERE", "LOADING")
                }
                is ResultState.SUCCESS<*> -> {
                    Log.d("HERE", "onCreateView: ${state.response}")
                    (state as ResultState.SUCCESS<SchoolsItem>).response
                    state.response.let {
                        binding.apply {
                            schoolRv.adapter = SchoolsAdapter(it, ::showDetails)
                            schoolRv.layoutManager = LinearLayoutManager(context)
                        }
                    }
                }
                is ResultState.ERROR -> {
                    Log.d("HERE", "${state.e.toString()}")
                }
            }
        }

        schoolViewModel.getSchools()

        return binding.root
    }

    private fun showDetails(dbn: String) {
        Log.d("HERE", dbn)
        parentFragmentManager.beginTransaction()
            .replace(R.id.school_nav_container, ScoresFragment.newInstance(dbn))
            .addToBackStack(null)
            .commit()
    }

}