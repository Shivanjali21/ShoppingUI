package com.practice.shoppingapp.models.homeshop.flashsale

data class FlashSaleData(
    val fsImg : Int,
    val fsName : String,
    val fsCode: String,
    val fsOfferPrice:String,
    val fsOriginalPrice:String,
    val fsPercentOffer:String,
)