package com.hur.milkpurification.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.firebase.database.*
import com.hur.milkpurification.R
import com.hur.milkpurification.databinding.ActivityHomeBinding
import com.hur.milkpurification.model.UserInfo


class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var navController: NavController? = null
    private val currentLat = 0.0
    private val currentLng = 0.0

    private val fusedLocationProviderClient: FusedLocationProviderClient? = null

    private lateinit var dbReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val database = FirebaseDatabase.getInstance()
        val dbReference = database.getReference("milkDepthInInches")
//        dbReference.setValue("milkDepthInInches");


        binding.btnRead.setOnClickListener {
            dbReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                     var userProfile = snapshot.getValue(Long::class.java)

                    Log.d("FCMVALUE", userProfile.toString())

                    binding.txtCheck.text = userProfile.toString()

                    showToast(userProfile.toString())
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        }
    }

    fun showToast(message : String){

        Toast.makeText(this, "Value has been changed $message inches", Toast.LENGTH_SHORT).show()
    }
}