package com.hur.milkpurification.activity

import android.os.Bundle
import com.hur.milkpurification.databinding.ActivityLoginBinding
import com.hur.milkpurification.gotoActivity
import com.hur.milkpurification.gotoActivityWithNoHistory
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
                if (binding.etPhone.text.contentEquals("03366830224")){
                    if (binding.etPassword.text.contentEquals("hur")){
                        gotoActivityWithNoHistory(HomeActivity::class.java)
                    }
                    else{
                        binding.etPassword.error = "Wrong Password"
                    }
                }else if (binding.etPhone.text.contentEquals("12345")
                    && binding.etPassword.text.contentEquals("123")){
                    gotoActivityWithNoHistory(DriverActivity::class.java)

                }
                else{
                    binding.etPhone.error = "Wrong Phone Number"

                }
            }
        }

        }


    }
