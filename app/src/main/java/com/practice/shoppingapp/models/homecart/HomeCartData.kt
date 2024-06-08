package com.practice.shoppingapp.models.homecart

data class HomeCartData(
    val cartImg : Int,
    val cartName : String,
    val cartPrice:String,
    val cartCode: String,
    val cartQty:Int,
    val cartTotal:String,
    val cartSize :String,
    val cartColor:Int
)