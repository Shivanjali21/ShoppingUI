package com.practice.shoppingapp.extension

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.practice.shoppingapp.R

fun Fragment.findRootNavController(): NavController =
    requireActivity().findNavController(R.id.mainFCV)
