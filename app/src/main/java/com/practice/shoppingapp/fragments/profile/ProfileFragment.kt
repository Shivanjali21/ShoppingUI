package com.practice.shoppingapp.fragments.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.google.android.material.textview.MaterialTextView
import com.practice.shoppingapp.R
import com.practice.shoppingapp.activities.home.HomeActivity
import com.practice.shoppingapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val binding : FragmentProfileBinding by lazy {
       FragmentProfileBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            mbLogOut.setOnClickListener {
                val md = AlertDialog.Builder(requireContext(), R.style.Theme_CustomMaterialAlert).create()
                val customLayout: View = layoutInflater.inflate(R.layout.layout_logout_custom_dialog, null)
                val btnLogout = customLayout.findViewById<MaterialTextView>(R.id.mBtnLogout)
                btnLogout.setOnClickListener {
                    md.dismiss()
//                    val action = HomeFragmentDirections.actionHomeFragmentToLoginInFragment()
//                    findRootNavController().navigate(action)
                }
                val btnCancel = customLayout.findViewById<MaterialTextView>(R.id.mBtnCancel)
                btnCancel.setOnClickListener {
                   md.dismiss()
                }
                md.setView(customLayout)
                md.setCanceledOnTouchOutside(false)
                md.show()
            }

            mbEditProfile.setOnClickListener {
               val action = ProfileFragmentDirections.actionProfileFragmentToEditProfileFragment()
               findNavController().navigate(action)
            }
        }

        return binding.profileFragRoot
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as HomeActivity).hideShowBottomNavigation()
    }

    override fun onDetach() {
        (activity as HomeActivity).hideShowBottomNavigation()
        super.onDetach()
    }
}