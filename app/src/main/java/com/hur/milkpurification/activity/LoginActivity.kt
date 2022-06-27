package com.hur.milkpurification.activity

import android.os.Bundle
import com.hur.milkpurification.databinding.ActivityLoginBinding
import com.hur.milkpurification.gotoActivity
import com.hur.milkpurification.listener.GenericListeners

class LoginActivity :  BaseActivity()
{
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listener = object : GenericListeners {

            override fun onTapSignup() {
                gotoActivity(SignUpActivity::class.java)

            }


            override fun onTapLogin() {
                gotoActivity(HomeActivity::class.java)

            }
        }

        }


    }
