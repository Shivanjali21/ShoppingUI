package com.practice.shoppingapp.fragments.btmnavi.home.shophome.seemore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.fragment.navArgs
import com.practice.shoppingapp.R
import com.practice.shoppingapp.databinding.FragmentFSDetailBinding
import com.practice.shoppingapp.models.homeshop.fsdcolordata.FSDColorData
import com.practice.shoppingapp.models.homeshop.fsdsizedata.FSDSizeData
class FSDetailFragment : Fragment(R.layout.fragment_f_s_detail) {

    private val binding : FragmentFSDetailBinding by lazy {
       FragmentFSDetailBinding.inflate(layoutInflater)
    }
    private lateinit var sizeList : ArrayList<FSDSizeData>
    private val fsdSizeAdapter : FSDSizeAdapter by lazy {
        FSDSizeAdapter(sizeList)
    }
    private var count = 0
    private lateinit var colorList : ArrayList<FSDColorData>
    private val fsdColorAdapter : FSDColorAdapter by lazy {
        FSDColorAdapter(colorList)
    }
    //private val argsReceive : FSDetailFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            sizeList = ArrayList()
            sizeList.add(FSDSizeData("UK10"))
            sizeList.add(FSDSizeData("UK4"))
            sizeList.add(FSDSizeData("UK8"))
            sizeList.add(FSDSizeData("UK10"))
            sizeList.add(FSDSizeData("UK6"))
            sizeList.add(FSDSizeData("UK8"))
            sizeList.add(FSDSizeData("UK12"))
            rvSize.apply {
                adapter = fsdSizeAdapter
            }

            mtvFSDMinus.setOnClickListener {
                if (count == 0) {
                    mtvFSDQty.text = "0"
                    //mtvFSDQty.visibility = View.GONE
                    //mtvFSDPlus.visibility = View.VISIBLE
                }else{
                    count--
                    mtvFSDQty.text = count.toString()
                }
            }
            mtvFSDPlus.setOnClickListener {
                count++
                mtvFSDQty.text = count.toString()
            }

            rvColor.apply {
                colorList = ArrayList()
                colorList.add(FSDColorData(R.color.colorTheme))
                colorList.add(FSDColorData(R.color.colorRed))
                colorList.add(FSDColorData(R.color.colorHint))
                colorList.add(FSDColorData(R.color.colorBlack))
                colorList.add(FSDColorData(R.color.colorWhite))
                colorList.add(FSDColorData(R.color.colorLBlack))
                colorList.add(FSDColorData(R.color.colorYellow))
                rvColor.apply {
                    adapter = fsdColorAdapter
                }
            }

//            ivFSDetailImg.setImageResource(argsReceive.fsDetailData.fsMoreImg)
//            mtvFSDName.text = argsReceive.fsDetailData.fsMoreName
//            mtvFSDPrice.text = argsReceive.fsDetailData.fsMorePrice
        }

        return binding.fsDFragRoot
    }

}