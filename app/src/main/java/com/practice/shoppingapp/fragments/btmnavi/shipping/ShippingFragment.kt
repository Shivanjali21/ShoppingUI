package com.practice.shoppingapp.fragments.btmnavi.shipping

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.FragmentShippingBinding
import com.practice.shoppingapp.models.homeshop.fseemoredata.FSSeeMoreData

class ShippingFragment : Fragment(R.layout.fragment_shipping) {

    private val binding: FragmentShippingBinding by lazy {
       FragmentShippingBinding.inflate(layoutInflater)
    }

    private var sCartList = ArrayList<FSSeeMoreData>()
    private val sCartAdapter : ShippingCartAdapter by lazy {
       ShippingCartAdapter(sCartList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            mbContShipping.setOnClickListener {
//               val action = ShippingFragmentDirections.actionShippingFragmentToPaymentFragment()
//               findNavController().navigate(action)
            }

            sCartList = ArrayList()
            sCartList.add(FSSeeMoreData(R.drawable.fs_model_one, "New Outfit for you  show now ","\u20B9 5740", "GF1024","UK10",R.color.colorHint))
            sCartList.add(FSSeeMoreData(R.drawable.fs_model_two, "New Outfit for you  show now ","\u20B9 5270","GF1025","UK8", R.color.colorRed))
            sCartList.add(FSSeeMoreData(R.drawable.fs_model_three, "New Outfit for you  show now ","\u20B9 3640", "GF1026","UK10", R.color.colorTheme))
            sCartList.add(FSSeeMoreData(R.drawable.fs_blouse, "New Outfit for you  show now ","\u20B9 3000", "GF1027","UK8",R.color.colorBlack))
            sCartList.add(FSSeeMoreData(R.drawable.fs_model_four, "New Outfit for you  show now ","\u20B9 2000", "GF1028","UK10", R.color.colorTheme))

            rvShippingItem.apply {
               adapter = sCartAdapter
            }
        }

        return binding.paymentFragRoot
    }
}