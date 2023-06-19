package com.example.myproject_easycafe


import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject_easycafe.databinding.HeaderPricelistBinding
import com.example.myproject_easycafe.databinding.ItemPricelistBinding

class PricelistAdapter(
    private val listener: OnItemClickListener,
    private val listenerLong: OnLongClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private const val HEADER = 0
        private const val ITEM = 1
    }


    inner class ItemViewHolder(val itemBinding: ItemPricelistBinding):
        RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener, View.OnLongClickListener {
        fun bind(item: DataItem.ItemPricelist) {
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

        init {
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listenerLong.onLongClick(position)
            }
            return true
        }
    }

    inner class HeaderViewHolder(val headerBinding: HeaderPricelistBinding) :
        RecyclerView.ViewHolder(headerBinding.root) {
        fun bind(header: DataItem.HeaderPricelist) {
            headerBinding.header = header
        }
    }

    private val itemList = mutableListOf<DataItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            ITEM -> ItemViewHolder(ItemPricelistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
            )
            HEADER -> HeaderViewHolder(
                HeaderPricelistBinding.inflate(
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
        val diffCallback = DiffCallback(itemList,updatedList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        itemList.clear()
        itemList.addAll(updatedList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setData(updatedList: MutableList<DataItem>){
        val diffCallback = DiffCallback(itemList,updatedList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        itemList.clear()
        itemList.addAll(updatedList)
        diffResult.dispatchUpdatesTo(this)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    interface OnLongClickListener {
        fun onLongClick(position: Int)
    }

}