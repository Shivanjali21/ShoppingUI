package com.practice.shoppingapp.fragments.btmnavi.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.FragmentHomeBinding
import com.practice.shoppingapp.fragments.btmnavi.home.shophome.carousel.CarouselImageAdapter
import com.practice.shoppingapp.fragments.btmnavi.home.shophome.categories.CategoriesAdapter
import com.practice.shoppingapp.fragments.btmnavi.home.shophome.flashsale.FlashSaleAdapter
import com.practice.shoppingapp.models.homeshop.carousel.CarouselItem
import com.practice.shoppingapp.models.homeshop.categories.CategoriesData
import com.practice.shoppingapp.models.homeshop.flashsale.FlashSaleData

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding : FragmentHomeBinding by lazy {
       FragmentHomeBinding.inflate(layoutInflater)
    }

    private lateinit var carouselList : ArrayList<CarouselItem>
    private val carouselAdapter: CarouselImageAdapter by lazy {
        CarouselImageAdapter()
    }
    private lateinit var categoriesList : ArrayList<CategoriesData>
    private val categoriesAdapter : CategoriesAdapter by lazy {
        CategoriesAdapter(categoriesList)
    }

    private lateinit var fsList : ArrayList<FlashSaleData>
    private val flashSaleAdapter : FlashSaleAdapter by lazy {
        FlashSaleAdapter(fsList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {

            ivNotification.setOnClickListener {
//               val action = HomeFragmentDirections.actionHomeFragmentToNotificationFragment()
//               findNavController().navigate(action)
            }

            mtvFSMoreTag.setOnClickListener {
//                val action = HomeFragmentDirections.actionHomeFragmentToSeeMoreFragment()
//                findNavController().navigate(action)
            }

            categoriesList = ArrayList()
            categoriesList.add(CategoriesData("Dresses",R.drawable.dress_icon))
            categoriesList.add(CategoriesData("Tops", R.drawable.top_icon))
            categoriesList.add(CategoriesData("Bottoms", R.drawable.jeans_icon))
            categoriesList.add(CategoriesData("Jeans", R.drawable.jumpsuit_icon))
            categoriesList.add(CategoriesData("Frocks", R.drawable.frock_icon))
            categoriesList.add(CategoriesData("Shirt", R.drawable.shirt_icon))
            categoriesList.add(CategoriesData("T-Shirt", R.drawable.tshirt_icon))

            rvCategories.apply {
                adapter = categoriesAdapter
            }

            carouselList = ArrayList()
            carouselList.add(CarouselItem(1,R.drawable.banner_one))
            carouselList.add(CarouselItem(2, R.drawable.banner_two))
            carouselList.add(CarouselItem(3, R.drawable.banner_three))
            carouselList.add(CarouselItem(4, R.drawable.banner_four))

            rvCarousel.apply {
                adapter = carouselAdapter
                carouselAdapter.submitList(carouselList)
            }

            fsList = ArrayList()
            fsList.add(FlashSaleData(R.drawable.fs_model_one, "One Shoulder\nLinen Dress", "GF1025","\u20B9 5740","\u20B9 7180","20% off"))
            fsList.add(FlashSaleData(R.drawable.fs_model_two, "Puff Sleeve\nDress", "GF1047","\u20B9 6200", "\u20B9 5270","10% off"))
            fsList.add(FlashSaleData(R.drawable.fs_model_three, "Cross Stitch\nTop", "GF1020","\u20B9 4600", "\u20B9 3640","15% off"))
            fsList.add(FlashSaleData(R.drawable.fs_model_four, "Linen Dress\nFrock", "GF1030","\u20B9 2000", "\u20B9 3000","5% off"))

            rvFLashSale.apply {
                adapter = flashSaleAdapter
            }
        }

        return binding.homeFragRoot
    }
}