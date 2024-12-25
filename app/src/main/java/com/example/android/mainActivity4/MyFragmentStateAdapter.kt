package com.example.android.mainActivity4

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android.fragmentler.A
import com.example.android.fragmentler.B
import com.example.android.fragmentler.C
import com.example.android.fragmentler.D
import com.example.android.fragmentler.E

class MyFragmentStateAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {

    //istediğimiz fragmanları buraya ekleriz
    var fragmentList = listOf(
        A(),
        B(),
        C(),
        D(),
        E()
    )

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = fragmentList[position]
        return fragment;
    }
}