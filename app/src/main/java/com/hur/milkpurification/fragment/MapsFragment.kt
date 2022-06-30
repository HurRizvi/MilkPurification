package com.hur.milkpurification.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hur.milkpurification.R
import com.hur.milkpurification.databinding.ActivityHomeBinding
import com.hur.milkpurification.databinding.FragmentMapsBinding
import com.ingenious.pakgateuser.ui.fragment.BaseFragment

class MapsFragment :BaseFragment<FragmentMapsBinding>() {


    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */



        googleMap.setOnMapClickListener {
            val googlePlex = CameraPosition.builder()
                .target(LatLng(24.9737236,67.0445783))
                .zoom(15f)
                .bearing(0f)
                .tilt(50f)
                .build()
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(googlePlex), 10000, null)

        }

        val pakistan = LatLng(24.9737236,67.0445783)
        googleMap.addMarker(MarkerOptions().position(pakistan).title("Karachi"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pakistan))

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
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)


    }

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMapsBinding
        get() = TODO("Not yet implemented")
}