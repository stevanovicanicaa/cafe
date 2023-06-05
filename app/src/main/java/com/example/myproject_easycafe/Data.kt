package com.example.myproject_easycafe

object Data {

    fun getItems(): List<DataItem> {

        var itemList = mutableListOf<DataItem>()

        itemList.add(DataItem.HeaderBillList(200.00))
        itemList.add(DataItem.ItemBillList(70.00, 4.00, 10.00))
        itemList.add(DataItem.ItemBillList(30.00, 2.00, 10.00))
        itemList.add(DataItem.ItemBillList(100.00, 6.00, 10.00))


        return itemList
    }

    fun getItems1(): List<DataItem>{
        var itemList = mutableListOf<DataItem>()

        itemList.add(DataItem.HeaderPricelist("Drinks"))
        itemList.add(DataItem.ItemPricelist("Espresso", 4.5))
        itemList.add(DataItem.ItemPricelist("Cappucino", 4.5))
        itemList.add(DataItem.ItemPricelist("Mineral water", 5.0))
        itemList.add(DataItem.ItemPricelist("Coke", 4.0))
        itemList.add(DataItem.ItemPricelist("Fanta", 4.0))
        itemList.add(DataItem.ItemPricelist("Sprite", 4.0))

        itemList.add(DataItem.HeaderPricelist("Appetizers"))
        itemList.add(DataItem.ItemPricelist("Fried Calamari", 8.95))
        itemList.add(DataItem.ItemPricelist("Grilled Asparagues", 7.95))
        itemList.add(DataItem.ItemPricelist("Greens, Beans and Tomatoes", 7.0))
        itemList.add(DataItem.ItemPricelist("Spaghetti & Meatballs", 10.0))
        itemList.add(DataItem.ItemPricelist("Macaroni Soap", 14.0))

        itemList.add(DataItem.HeaderPricelist("Main course"))
        itemList.add(DataItem.ItemPricelist("Bruschetta", 9.0))
        itemList.add(DataItem.ItemPricelist("Fried Calamari", 8.0))
        itemList.add(DataItem.ItemPricelist("Four Cheese Garlic Bread", 5.0))
        itemList.add(DataItem.ItemPricelist("Spaghetti Bologneze", 13.0))

        itemList.add(DataItem.HeaderPricelist("Desserts"))
        itemList.add(DataItem.ItemPricelist("Cheese tart", 6.0))
        itemList.add(DataItem.ItemPricelist("Pudding", 5.7))
        itemList.add(DataItem.ItemPricelist("Strawberry Cake", 4.99))
        itemList.add(DataItem.ItemPricelist("Seafood Pancakes", 4.99))
        itemList.add(DataItem.ItemPricelist("Apple Crisp", 5.0))
        itemList.add(DataItem.ItemPricelist("Cheesecake", 6.0))
        itemList.add(DataItem.ItemPricelist("Tiramisu", 7.0))
        itemList.add(DataItem.ItemPricelist("Lava Cake", 5.99))

        return itemList
    }
}