package com.example.myproject_easycafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject_easycafe.databinding.FragmentPricelistBinding

class PricelistFragment : Fragment() {

    private lateinit var binding: FragmentPricelistBinding
    private val adapterList by lazy { MainAdapter_Pricelist() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pricelist, container, false)
        val view = binding.root

        binding.PricelistFAB.setOnClickListener {
            findNavController().navigate(R.id.action_oneFragment_to_newItemFragment)
        }


        val itemList = Data.getItems1()
        adapterList.updateList(itemList)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            adapter = adapterList
        }
        return view
    }
}