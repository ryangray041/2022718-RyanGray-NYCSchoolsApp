package com.example.nycschoolsv2.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nycschoolsv2.databinding.FragmentScoresBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * Here I am binding all the data I want to display in my Fragment
 *
 */

@AndroidEntryPoint
class ScoresFragment : BaseFragment() {

    private var _binding: FragmentScoresBinding? = null
    private val binding: FragmentScoresBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScoresBinding.inflate(layoutInflater)

        schoolViewModel.getSATScores(arguments?.getString(SCORE_DATA)!!)
        configureObserver()
        return binding.root
    }

    private fun configureObserver() {
        schoolViewModel.scores.observe(viewLifecycleOwner) { satScoresItem ->
            if(!satScoresItem.isNullOrEmpty()) {
                binding.apply {
                    schoolName.text = satScoresItem[0].schoolName
                    satReading.text = "Reading: ${ satScoresItem[0].satCriticalReadingAvgScore}"
                    satMath.text = "Math: ${satScoresItem[0].satMathAvgScore}"
                    satWriting.text = "Writing: ${satScoresItem[0].satWritingAvgScore}"

                    satReading.visibility = View.VISIBLE
                    satMath.visibility = View.VISIBLE
                    satWriting.visibility = View.VISIBLE
                }
            } else {
                binding.apply {
                    schoolName.text = "No school data available"
                    satReading.visibility = View.INVISIBLE
                    satMath.visibility = View.INVISIBLE
                    satWriting.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.apply {
            satReading.visibility = View.INVISIBLE
            satMath.visibility = View.INVISIBLE
            satWriting.visibility = View.INVISIBLE
        }
        _binding = null
    }

    companion object {
        const val SCORE_DATA = "SCORE_DATA"

        fun newInstance(dbn: String): ScoresFragment {
            val fragment = ScoresFragment()
            val bundle = Bundle()
            bundle.putString(SCORE_DATA, dbn)
            fragment.arguments = bundle
            return fragment
        }
    }

}