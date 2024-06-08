package com.practice.shoppingapp.fragments.btmnavi.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.FragmentPaymentBinding
import com.practice.shoppingapp.models.homeshop.fseemoredata.FSSeeMoreData

class PaymentFragment : Fragment(R.layout.fragment_payment) {

    private val binding : FragmentPaymentBinding by lazy {
       FragmentPaymentBinding.inflate(layoutInflater)
    }
    private var pCartList = ArrayList<FSSeeMoreData>()
    private val pCartAdapter : PaymentCartAdapter by lazy {
        PaymentCartAdapter(pCartList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            pCartList = ArrayList()
            pCartList.add(FSSeeMoreData(R.drawable.fs_model_one, "New Outfit for you  show now ","\u20B9 5740", "GF1024","UK10",R.color.colorHint))
            pCartList.add(FSSeeMoreData(R.drawable.fs_model_two, "New Outfit for you  show now ","\u20B9 5270","GF1025","UK8", R.color.colorRed))
            pCartList.add(FSSeeMoreData(R.drawable.fs_model_three, "New Outfit for you  show now ","\u20B9 3640", "GF1026","UK10", R.color.colorTheme))
            pCartList.add(FSSeeMoreData(R.drawable.fs_blouse, "New Outfit for you  show now ","\u20B9 3000", "GF1027","UK8",R.color.colorBlack))
            pCartList.add(FSSeeMoreData(R.drawable.fs_model_four, "New Outfit for you  show now ","\u20B9 2000", "GF1028","UK10", R.color.colorTheme))

            rvPayShippingItem.apply {
                adapter = pCartAdapter
            }

            mbPayNow.setOnClickListener {
                val md = AlertDialog.Builder(requireContext(), R.style.Theme_CustomMaterialAlert).create()
                val customLayout: View = layoutInflater.inflate(R.layout.layout_success_purchase_dialog, null)
                val btnSShop = customLayout.findViewById<MaterialButton>(R.id.mBtnSShop)
                btnSShop.setOnClickListener {
                    md.dismiss()
                    //findNavController().navigate(R.id.action_paymentFragment_to_homeFragment)
                }
                md.setView(customLayout)
                md.setCanceledOnTouchOutside(false)
                md.show()
            }
        }

        return binding.shippingFragRoot
    }
}