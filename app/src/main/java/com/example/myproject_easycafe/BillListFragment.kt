package com.example.myproject_easycafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject_easycafe.databinding.FragmentBillListBinding


class BillListFragment : Fragment() {

    private lateinit var binding: FragmentBillListBinding
    private val adapterList by lazy { BillListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bill_list, container, false)
        val view = binding.root

        binding.BillListFAB.setOnClickListener {
            findNavController().navigate(R.id.action_oneFragment_to_newBillFragment)
        }

        val itemList = Data.getItems()
        adapterList.updateList(itemList)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
            itemAnimator = DefaultItemAnimator()
            adapter = adapterList
        }
        return view
    }
}
