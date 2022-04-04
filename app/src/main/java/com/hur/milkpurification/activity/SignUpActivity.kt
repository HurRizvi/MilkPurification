package com.hur.milkpurification.activity

import android.os.Bundle
import com.hur.milkpurification.databinding.ActivitySignupBinding

class SignUpActivity : BaseActivity() {
    private lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    }


