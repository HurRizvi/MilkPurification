package com.hur.milkpurification.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import com.hur.milkpurification.databinding.ActivitySplashBinding
import com.hur.milkpurification.gotoActivity
import com.hur.milkpurification.listener.GenericListeners

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Set the application Orientation
         */
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        /**
         * Binding Listeners
         */
        binding.listener = object : GenericListeners {

            override fun onTapSubmit() {
                gotoActivity(LoginActivity::class.java)

            }
        }


    }
}