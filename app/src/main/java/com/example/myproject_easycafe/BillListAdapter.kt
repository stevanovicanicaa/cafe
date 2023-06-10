package com.example.myproject_easycafe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject_easycafe.databinding.HeaderBillListBinding
import com.example.myproject_easycafe.databinding.ItemBillListBinding
import java.text.DateFormat
import java.util.*

class BillListAdapter(
    private val listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val HEADER = 0
        private const val ITEM = 1
    }

    inner class ItemViewHolder(val itemBinding: ItemBillListBinding) :
        RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

        fun bind(item: DataItem.ItemBillList) {
            val calendar = Calendar.getInstance()
            val currentTime: String =
                DateFormat.getDateInstance().format(calendar.getTime())
            itemBinding.time.text = currentTime
            itemBinding.item = item
        }

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    inner class HeaderViewHolder(val headerBinding: HeaderBillListBinding) :
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
            ITEM -> ItemViewHolder(
                ItemBillListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            HEADER -> HeaderViewHolder(
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
            is DataItem.ItemBillList -> ITEM
            is DataItem.HeaderBillList -> HEADER
            else -> throw IllegalArgumentException("Invalid Item")
        }
    }

    fun updateList(updatedList: List<DataItem>){
        val diffCallback = DiffCallback(itemList,updatedList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        itemList.clear()
        itemList.addAll(updatedList)
        diffResult.dispatchUpdatesTo(this)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}
