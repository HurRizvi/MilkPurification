package com.hur.milkpurification.activity

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.firebase.database.*
import com.hur.milkpurification.R
import com.hur.milkpurification.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var navController: NavController? = null
    private val currentLat = 0.0
    private val currentLng = 0.0

    private val fusedLocationProviderClient: FusedLocationProviderClient? = null

//    private lateinit var dbReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*    NavHostFragment finalHost = NavHostFragment.create(R.navigation.nav_graph);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_Fragmnet,finalHost)
                .setPrimaryNavigationFragment(finalHost) // equivalent to app:defaultNavHost="true"
                .commit();*/


        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val id: Int = item.getItemId()
            when (id) {
                R.id.homeFragment -> {
                    navController = Navigation.findNavController(
                        this,
                        R.id.navHostFragment
                    )
                    navController!!.navigate(R.id.homeFragment, null)
                }
            }
            true
        }


        /**
         * Setup Navigation
         */
        //binding.bottomNavigation.background = null

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(
            binding.bottomNavigation ,
            navHostFragment.navController
        )




//      val  firebase = FirebaseDatabase.getInstance()
//        dbReference = FirebaseDatabase.getInstance().getReference(firebase.getReference().toString())



//        binding.btnRead.setOnClickListener {
//            dbReference.addValueEventListener(object : ValueEventListener{
//                override fun onDataChange(snapshot: DataSnapshot) {
//                     val userProfile = snapshot.getValue(UserInfo::class.java)
//                    val a = userProfile!!.Milk_Depth
//                    Log.d("FCMVALUE", a.toString())
//                    binding.txtCheck.setText(userProfile?.Milk_Depth!!)
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//
//                }
//
//            })
//        }

//        dbReference.child("users").child(userId).setValue(user)
//
//        dbReference.child("users").child(userId).child("name").setValue(name)


    }



//    private fun createUser(name: String, mobile: String) {
//        val user = UserInfo(name, mobile)
//        dbReference.child(userId).setValue(user)
//    }
//
//    private fun addUserChangeListener() {
//        // User data change listener
//        dbReference.child(userId).addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val user = dataSnapshot.getValue(UserInfo::class.java)
//
//                // Check for null
//                if (user == null) {
//                    return
//                }
//
//
//                // Display newly updated name and email
//                userNameTv.setText(user?.name).toString()
//                userMobileTv.setText(user?.mobile).toString()
//
//                // clear edit text
//                userNameEt.setText("")
//                userMobileEt.setText("")
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Failed to read value
//            }
//        })
//    }
}