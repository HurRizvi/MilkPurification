package com.ingenious.pakgateuser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.hur.milkpurification.utils.CustomProgressDialog


abstract class BaseFragment<VB: ViewBinding> : Fragment()
{
    lateinit var binding: VB
    private lateinit var dialog: CustomProgressDialog

    //    public KProgressHUD mProgressBar;

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * init custom progress dialog
         */
        dialog = CustomProgressDialog(requireActivity())
    }

    fun showProgressDialog() {
        dialog.show()
    }

    fun hideProgressDialog(){
        dialog.dismiss()
    }





}