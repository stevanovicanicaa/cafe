package com.example.myproject_easycafe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject_easycafe.Data.HEADER_BL
import com.example.myproject_easycafe.Data.ITEM_BL
import com.example.myproject_easycafe.databinding.HeaderBillListBinding
import com.example.myproject_easycafe.databinding.ItemBillListBinding
import java.text.DateFormat
import java.util.*

class MainAdapter_BillList : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(val itemBinding: ItemBillListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: DataItem.ItemBillList) {
            val calendar = Calendar.getInstance()
            val currentTime: String =
                DateFormat.getTimeInstance().format(calendar.getTime())
            itemBinding.time.text = currentTime

            itemBinding.item = item
        }
    }

    class HeaderViewHolder(val headerBinding: HeaderBillListBinding) :
        RecyclerView.ViewHolder(headerBinding.root) {
        fun bind(header: DataItem.HeaderBillList) {

            val calendar = Calendar.getInstance()
            val currentDate: String =
                DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime())
            headerBinding.date.text=currentDate

            headerBinding.header = header
        }
    }

    private val itemList = mutableListOf<DataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_BL -> ItemViewHolder(
                ItemBillListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            HEADER_BL -> HeaderViewHolder(
                HeaderBillListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw java.lang.IllegalArgumentException("Invalid ViewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder -> holder.bind(itemList[position] as DataItem.ItemBillList)
            is HeaderViewHolder -> holder.bind(itemList[position] as DataItem.HeaderBillList)
        }
    }


    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is DataItem.ItemBillList -> ITEM_BL
            is DataItem.HeaderBillList -> HEADER_BL
            else -> throw IllegalArgumentException("Invalid Item")
        }
    }

    fun updateList(updatedList: List<DataItem>){
        itemList.clear()
        itemList.addAll(updatedList)
        notifyDataSetChanged()
    }
}





