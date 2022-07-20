package com.hur.milkpurification.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.hur.milkpurification.R
import com.hur.milkpurification.databinding.ActivityDriverBinding
import com.hur.milkpurification.gotoActivityWithNoHistory
import com.hur.milkpurification.model.Driver

class DriverActivity : AppCompatActivity() {
    private var mDatabase: DatabaseReference? = null
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var binding : ActivityDriverBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDriverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mDatabase = FirebaseDatabase.getInstance().reference;

        binding.btnStop.setOnClickListener{
            val i = Intent(this, LoginActivity::class.java)
            i.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)

        }


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        /* fusedLocationClient.lastLocation.addOnSuccessListener(requireActivity(), OnSuccessListener<Any?> { location ->
                 // Got last known location. In some rare situations this can be null.
                 if (location != null) {
                     // Logic to handle location object
                     writeNewUser(LatLng())
                 }
             })
 */

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null)

                writeNewUser(location.latitude,location.longitude)
        }


    }

    private fun writeNewUser(latitude : Double, longitude : Double) {
        /*      val geocoder = Geocoder(context, Locale.getDefault())
              val addresses: List<Address> = geocoder.getFromLocation(latitude, longitude, 1)
      */
        val driver = Driver(latitude, longitude)
        mDatabase!!.child("driver").setValue(driver)

    }
}