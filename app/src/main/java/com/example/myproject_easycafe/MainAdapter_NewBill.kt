package com.example.myproject_easycafe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject_easycafe.Data.HEADER
import com.example.myproject_easycafe.Data.ITEM
import com.example.myproject_easycafe.databinding.HeaderNewBillBinding
import com.example.myproject_easycafe.databinding.ItemNewBillBinding


class MainAdapter_NewBill : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(val itemBinding: ItemNewBillBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: DataItem.ItemPricelist){
            itemBinding.item = item
        }
    }
    class HeaderViewHolder(val headerBinding: HeaderNewBillBinding) :
        RecyclerView.ViewHolder(headerBinding.root) {
        fun bind(header: DataItem.HeaderPricelist) {
            headerBinding.header = header
        }
    }

    private val itemList = mutableListOf<DataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            ITEM -> ItemViewHolder(ItemNewBillBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
            )
            HEADER -> HeaderViewHolder(
                HeaderNewBillBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false)
            )
            else -> throw java.lang.IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun getItemCount(): Int = itemList.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ItemViewHolder -> holder.bind(itemList[position] as DataItem.ItemPricelist)
            is HeaderViewHolder -> holder.bind(itemList[position] as DataItem.HeaderPricelist)
        }
    }
    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is DataItem.ItemPricelist -> ITEM
            is DataItem.HeaderPricelist -> HEADER
            else -> throw IllegalArgumentException("Invalid Item")
        }
    }
    fun updateList(updatedList: List<DataItem>){
        itemList.clear()
        itemList.addAll(updatedList)
        notifyDataSetChanged()
    }


}
