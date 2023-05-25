package com.example.myproject_easycafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproject_easycafe.databinding.FragmentNewBillBinding

class NewBillFragment : Fragment() {

    private lateinit var binding: FragmentNewBillBinding
    private val adapterList by lazy { MainAdapter_NewBill() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_bill, container, false)
        val view = binding.root

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_newBillFragment_to_billDetailsFragment)
        }

        val itemList = Data.getItems1()
        adapterList.updateList(itemList)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterList
        }
        return view
    }
}

