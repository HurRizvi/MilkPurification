package com.hur.milkpurification.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hur.milkpurification.R
import com.hur.milkpurification.databinding.FragmentHomeBinding
import com.ingenious.pakgateuser.ui.fragment.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = TODO("Not yet implemented")


}