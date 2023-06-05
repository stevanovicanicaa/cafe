package com.example.myproject_easycafe


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myproject_easycafe.databinding.FragmentBillDetailsBinding

class BillDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBillDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_bill_details, container, false)
        val view = binding.root

        return view
    }
}

