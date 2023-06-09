package com.example.myproject_easycafe

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject_easycafe.databinding.FragmentPricelistBinding

class PricelistFragment : Fragment(), PricelistAdapter.OnItemClickListener, PricelistAdapter.OnLongClickListener {

    private lateinit var binding: FragmentPricelistBinding
    private val adapterList by lazy { PricelistAdapter(this, this) }
    private lateinit var itemList: List<DataItem>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pricelist, container, false)
        val view = binding.root

        binding.PricelistFAB.setOnClickListener {
            findNavController().navigate(R.id.action_oneFragment_to_newItemFragment)
        }

        itemList = Data.getItems1()
        adapterList.updateList(itemList)

        binding.message.visibility = View.GONE

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterList
        }


        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                filterList(s.toString().trim())
            }
        })

        return view
    }

    private fun filterList(filterText: String) {
        val filteredList = mutableListOf<DataItem>()
        if (filterText.length >= 3) {
            for (item in itemList) {
                if (item.toString().lowercase().contains(filterText.lowercase())) {
                    filteredList.add(item)
                }
            }
            adapterList.setData(filteredList)
            binding.recyclerView.visibility = View.VISIBLE
            binding.message.visibility = View.GONE
            if (filteredList.isEmpty()) {
                binding.recyclerView.visibility = View.GONE
                binding.message.visibility = View.VISIBLE
            }
        } else {
            adapterList.updateList(itemList)
            binding.recyclerView.visibility = View.VISIBLE
            binding.message.visibility = View.GONE
        }
    }
    override fun onItemClick(position: Int) {
        findNavController().navigate(R.id.action_oneFragment_to_newItemFragment)
    }
    override fun onLongClick(position: Int) {
        AlertDialog.Builder(activity)
            .setMessage("Do you want to delete this item?")
            .setCancelable(true)
            .setPositiveButton("Yes"){dialogInterface, it ->
                Toast.makeText(activity,"You clicked YES", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No"){dialogInterface, it -> dialogInterface.cancel()}
            .show()
    }
}