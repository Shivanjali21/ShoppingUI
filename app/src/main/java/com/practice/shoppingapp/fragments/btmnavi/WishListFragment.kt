package com.practice.shoppingapp.fragments.btmnavi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.FragmentWishlistBinding
import com.practice.shoppingapp.fragments.btmnavi.home.shophome.seemore.FSSeeMoreAdapter
import com.practice.shoppingapp.models.homeshop.fseemoredata.FSSeeMoreData

class WishListFragment : Fragment(R.layout.fragment_wishlist) {

    private val binding : FragmentWishlistBinding by lazy {
       FragmentWishlistBinding.inflate(layoutInflater)
    }
    private lateinit var fsSeeMoreList : ArrayList<FSSeeMoreData>
    private val fsSeeMoreAdapter : FSSeeMoreAdapter by lazy {
        FSSeeMoreAdapter(fsSeeMoreList)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            fsSeeMoreList = ArrayList()
            fsSeeMoreList.add(FSSeeMoreData(R.drawable.fs_model_one, "New Outfit for you  show now ","\u20B9 5740", "GF1024","UK10",R.color.colorHint))
            fsSeeMoreList.add(FSSeeMoreData(R.drawable.fs_model_two, "New Outfit for you  show now ","\u20B9 5270","GF1025","UK8", R.color.colorRed))
            fsSeeMoreList.add(FSSeeMoreData(R.drawable.fs_model_three, "New Outfit for you  show now ","\u20B9 3640", "GF1026","UK10", R.color.colorTheme))
            fsSeeMoreList.add(FSSeeMoreData(R.drawable.fs_blouse, "New Outfit for you  show now ","\u20B9 3000", "GF1027","UK8",R.color.colorBlack))
            fsSeeMoreList.add(FSSeeMoreData(R.drawable.fs_model_four, "New Outfit for you  show now ","\u20B9 2000", "GF1028","UK10", R.color.colorTheme))

            rvWishList.apply {
                adapter = fsSeeMoreAdapter
            }
        }

        return binding.wishListFragRoot
    }
}