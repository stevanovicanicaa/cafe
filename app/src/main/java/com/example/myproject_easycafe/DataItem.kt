package com.example.myproject_easycafe

sealed class DataItem{

    data class ItemPricelist(val title: String, val price: Double): DataItem()
    data class HeaderPricelist(val header: String): DataItem()

    data class HeaderBillList(val price: Double) : DataItem()
    data class ItemBillList(val price: Double, val quantity: Double, val tip: Double): DataItem()

}