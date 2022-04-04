package com.hur.milkpurification.activity

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hur.milkpurification.utils.CustomProgressDialog

import pub.devrel.easypermissions.EasyPermissions

open class BaseActivity : AppCompatActivity()
{
    private lateinit var dialog: CustomProgressDialog

    lateinit var checkGPSDialog: MaterialAlertDialogBuilder

    private val SOME_PERMISSION = 0

    // Permission request code of any integer value
    private val PERMISSIONS = arrayOf(
        Manifest.permission.RECORD_AUDIO,
        Manifest.permission.CAMERA,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    lateinit var fusedLocation: FusedLocationProviderClient
    private var locationRequest: LocationRequest? = null
    private var locationCallback: LocationCallback? = null
    lateinit var latlng: LatLng

    /**
     * LocationFoundListener instance
     */
    var locationFoundListener: LocationFoundListener? = null

    /**
     * OnAllowPermissionListener instance
     */
    var allowPermissionListener: OnAllowPermissionListener? = null

    /**
     * Trigger when permissions are allowed
     */
    fun setOnPermissionAllowListener(listener: OnAllowPermissionListener) {
        allowPermissionListener = listener
    }

    /**
     * setting up listener callback to emit location to activity
     */
    fun setOnLocationFoundListener(listener: LocationFoundListener) {
        locationFoundListener = listener
    }

    private val changeForNetworkOrLocationProvider: BroadcastReceiver? =
        object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                if (!intent.action.isNullOrEmpty()) {
//                    checkGps()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        /* init custom progress dialog */
        dialog = CustomProgressDialog(this)

        /* init custom progress dialog */
        dialog = CustomProgressDialog(this)

        fusedLocationInitialization()

//        /**
//         * init GPS broadcast
//         */
//        val intentFilterNetwork = IntentFilter()
//        intentFilterNetwork.addAction(ON_GPS_ENABLED_CHANGE)
//        intentFilterNetwork.addAction(ON_LOCATION_CHANGED)
//        registerReceiver(changeForNetworkOrLocationProvider, intentFilterNetwork)

        /**
         * Check Permission
         */
        checkAndAskLocationPermission()
    }

    fun showProgressDialog() {
        dialog.show()
    }

    fun hideProgressDialog(){
        dialog.dismiss()
    }

//    /**
//     * Getting last known location of user using [FusedLocationProviderClient]]
//     */
//    fun getLastLocation() {
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        fusedLocation.lastLocation.addOnSuccessListener { location ->
//            if (location != null) {
//                val address = getAddressFromLocation(
//                    location.latitude,
//                    location.longitude
//                )
//                latlng = LatLng(location.latitude, location.longitude)
//                AppPreferences.userLocation = LocationModel().apply {
//                    this.latitude = latlng.latitude.toString()
//                    this.longitude = latlng.longitude.toString()
//                    this.address = address
//                }
//                locationFoundListener?.onLocationFound(latlng)
//            } else {
//                requestForLocation()
//            }
//
//        }.addOnFailureListener { }
//    }
//
//    /**
//     * Requesting location again if [FusedLocationProviderClient] failed to get location
//     */
//     fun requestForLocation() {
//        locationCallback = object : LocationCallback() {
//            override fun onLocationResult(result: LocationResult?) {
//                if (result == null) {
//                    locationFoundListener?.onLocationFound(null)
//                    return
//                }
//                for (location in result.locations) {
//                    if (location != null) {
//                        val address = getAddressFromLocation(
//                            location.latitude,
//                            location.longitude
//                        )
//                        latlng = LatLng(location.latitude, location.longitude)
//                        AppPreferences.userLocation = LocationModel().apply {
//                            this.latitude = latlng.latitude.toString()
//                            this.longitude = latlng.longitude.toString()
//                            this.address = address
//                        }
//                        locationFoundListener?.onLocationFound(latlng)
//                    } else {
//                        locationFoundListener?.onLocationFound(null)
//                    }
//                }
//            }
//        }
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//            != PackageManager.PERMISSION_GRANTED
//            && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            )
//            != PackageManager.PERMISSION_GRANTED
//        ) {
//            return
//        }
//        fusedLocation.requestLocationUpdates(
//            locationRequest,
//            locationCallback,
//            Looper.getMainLooper()
//        )
//    }

    private fun fusedLocationInitialization() {
        fusedLocation = LocationServices.getFusedLocationProviderClient(this)
        locationRequest = LocationRequest.create()
        locationRequest?.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest?.interval = 20 * 1000
    }


    override fun onResume() {
        super.onResume()
//        getLastLocation()
    }

    private fun checkAndAskLocationPermission() {
        if (EasyPermissions.hasPermissions(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) {
            /// Already have permission, do the thing
            allowPermissionListener?.onPermissionAllow(true)
        } else {
            EasyPermissions.requestPermissions(
                this,
                "We need to access",
                SOME_PERMISSION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        }
    }

//    private fun checkGps() {
//        if (!isGpsEnable(this)) {
//            checkGPSDialog.show()
//        } else {
//            //checkGPSDialog.dismiss()
//        }
//    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // EasyPermissions handles the request result.
//        onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    interface OnAllowPermissionListener {
        fun onPermissionAllow(allAllow: Boolean = false)
    }

    interface LocationFoundListener {
        fun onLocationFound(latLng: LatLng?)
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        //if (checkGPSDialog.isShowing) checkGPSDialog.dismiss()
//        changeForNetworkOrLocationProvider?.let {
//            unregisterReceiver(changeForNetworkOrLocationProvider)
//        }
//    }

}