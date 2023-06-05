package com.example.myproject_easycafe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.myproject_easycafe.databinding.FragmentOneBinding

class OneFragment : Fragment() {

    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)
        val view = binding.root

        setUpNav()

        return view
    }

    private fun setUpNav() {

        val fragments: ArrayList<Fragment> = arrayListOf()
        fragments.add(BillListFragment())
        fragments.add(PricelistFragment())

        val adapter = ViewPagerAdapter(fragments, this)
        binding.pagerMain.adapter = adapter
        binding.bottonNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.BillList -> binding.pagerMain.currentItem = 0
                R.id.Pricelist -> binding.pagerMain.currentItem = 1
            }
            false
        }

        binding.pagerMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottonNavView.menu.findItem(R.id.BillList).setChecked(true)
                    1 -> binding.bottonNavView.menu.findItem(R.id.Pricelist).setChecked(true)
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }
        })
    }
}