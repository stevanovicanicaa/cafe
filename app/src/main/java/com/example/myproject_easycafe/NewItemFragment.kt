package com.example.myproject_easycafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.myproject_easycafe.databinding.FragmentNewItemBinding


class NewItemFragment : Fragment() {

    private lateinit var binding: FragmentNewItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_item, container, false)
        val view = binding.root

        val options = arrayOf("Drinks","Appetizers","Main course","Desserts")
        val arrayAdapter  = context?.let {
            ArrayAdapter(it.applicationContext, android.R.layout.simple_list_item_1, options) }
        binding.category.adapter = arrayAdapter

        binding.category.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        return view
    }


}