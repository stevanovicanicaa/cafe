package com.example.myproject_easycafe


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

        binding.chargeReceipt.setOnClickListener {
            Toast.makeText(activity, "Button clicked", Toast.LENGTH_SHORT).show()
        }

        binding.message.visibility = View.GONE

        return view
    }
}
