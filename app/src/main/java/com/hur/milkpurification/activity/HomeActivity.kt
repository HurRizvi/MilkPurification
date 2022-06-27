package com.hur.milkpurification.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.database.*
import com.hur.milkpurification.databinding.ActivityHomeBinding
import com.hur.milkpurification.databinding.ActivityLoginBinding
import com.hur.milkpurification.model.UserInfo
import java.util.*

class HomeActivity : BaseActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var dbReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

      val  firebase = FirebaseDatabase.getInstance()
        dbReference = FirebaseDatabase.getInstance().getReference(firebase.getReference().toString())

        binding.btnRead.setOnClickListener {
            dbReference.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                     val userProfile = snapshot.getValue(UserInfo::class.java)
                    val a = userProfile!!.Milk_Depth
                    Log.d("FCMVALUE", a.toString())
                    binding.txtCheck.setText(userProfile?.Milk_Depth!!)
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        }

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