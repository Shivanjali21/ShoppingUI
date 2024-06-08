package com.practice.shoppingapp.fragments.btmnavi.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.FragmentCartBinding
import com.practice.shoppingapp.models.homecart.HomeCartData

class CartFragment : Fragment(R.layout.fragment_cart) {

    private val binding : FragmentCartBinding by lazy {
       FragmentCartBinding.inflate(layoutInflater)
    }
    private lateinit var cartList : ArrayList<HomeCartData>
    private val cartAdapter : HomeCartAdapter by lazy {
        HomeCartAdapter(cartList)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            cartList = ArrayList()
            cartList.add(HomeCartData(R.drawable.fs_model_one, "New Outfit for you  show now ","\u20B9 5740", "GF1024",2, "\u20B9 5740", "UK10",R.color.colorHint))
            cartList.add(HomeCartData(R.drawable.fs_model_two, "New Outfit for you  show now ","\u20B9 5270","GF1025",1,"\u20B9 5270","UK8", R.color.colorRed))
            cartList.add(HomeCartData(R.drawable.fs_model_three, "New Outfit for you  show now ","\u20B9 3640", "GF1026",4,"\u20B9 4000","UK10", R.color.colorTheme))
            cartList.add(HomeCartData(R.drawable.fs_blouse, "New Outfit for you  show now ","\u20B9 3000", "GF1027",3,"\u20B9 5270","UK8",R.color.colorBlack))
            cartList.add(HomeCartData(R.drawable.fs_model_four, "New Outfit for you  show now ","\u20B9 2000", "GF1028",6,"\u20B9 5270","UK10", R.color.colorTheme))

            rvHomeCart.apply {
                adapter = cartAdapter
            }
            mbCheckout.setOnClickListener {
//                val action = HomeFragmentDirections.actionHomeFragmentToShippingFragment()
//                findNavController().navigate(action)
            }
        }

        return binding.cartFragRoot
    }

}