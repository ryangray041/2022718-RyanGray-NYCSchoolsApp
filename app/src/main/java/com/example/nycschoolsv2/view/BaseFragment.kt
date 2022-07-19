package com.example.nycschoolsv2.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.nycschoolsv2.viewmodel.SchoolsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {

    protected val schoolViewModel: SchoolsViewModel by activityViewModels()
}