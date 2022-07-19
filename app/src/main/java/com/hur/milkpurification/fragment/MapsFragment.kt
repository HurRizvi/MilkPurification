package com.hur.milkpurification.fragment

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.hur.milkpurification.R
import com.hur.milkpurification.databinding.ActivityHomeBinding
import com.hur.milkpurification.databinding.FragmentMapsBinding
import com.hur.milkpurification.model.Driver
import com.ingenious.pakgateuser.ui.fragment.BaseFragment
import java.util.*

class MapsFragment :BaseFragment<FragmentMapsBinding>(), OnMapReadyCallback {


    private lateinit var mGoogleMap : GoogleMap
    private val database = FirebaseDatabase.getInstance()
//        dbReference.setValue("milkDepthInInches");

  /*  private val callback = OnMapReadyCallback { googleMap ->

        getUserCurrentLocation(googleMap)
        *//**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         *//*



     *//*   googleMap.setOnMapClickListener {
            val googlePlex = CameraPosition.builder()
                .target(LatLng(24.973723,67.0445783))
                .zoom(12.0f)
                .bearing(0f)
                .tilt(50f)
                .build()
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 1000, null)

        }*//*



    }*/

    private fun getUserCurrentLocation(map : GoogleMap, latitude: Double, longitude : Double){
        val googlePlex = CameraPosition.builder()
            .target(LatLng(latitude,longitude))
            .zoom(12.0f)
            .bearing(0f)
            .tilt(50f)
            .build()
        map.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 2000 , null)
        map.addMarker(MarkerOptions().position(LatLng(latitude,longitude))).isInfoWindowShown
        map.isMyLocationEnabled = true;

        /*val pakistan = LatLng(24.9737236,67.0445783)
        googleMap.addMarker(MarkerOptions().position(pakistan).title("Karachi"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pakistan))*/


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbReference = database.getReference("driver")

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)

        dbReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                var lat = snapshot.child("lat").value
                var lng = snapshot.child("lng").value

                Log.d("FCMVALUE", lat.toString()+""+lng.toString())

                //ye function comment kar dyna agr driver ki dhor dekhana ho to
                getUserCurrentLocation(mGoogleMap, lat as Double, lng as Double)

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMapsBinding
        get() = TODO("Not yet implemented")

    //LatLng(24.973723,67.0445783))

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap;
        // ye uncomment kar dyna or yahn  lat long nazimabad ki daal dyna abhi yahn pe iqra university north campus ki locatipon(kat,long) set hoi hai
//        getUserCurrentLocation(mGoogleMap,24.973723,67.0445783);
    }

}