package com.hur.milkpurification.utils;

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.net.ConnectivityManager
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import com.hur.milkpurification.koin.InjectUtils
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.util.*

/**
 * Created by jforjari@gmail.com.
 * Email: ingenious.hur@gmail.com
 */
object Utils
{
    fun isValidEmail(email: String): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isOnline(): Boolean {
        val cm =
            InjectUtils.appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null
    }

    fun getSimpleTextBody(param: String): RequestBody {
        return param.toRequestBody("text/plain".toMediaTypeOrNull())
    }

    fun getAddressFromLocation(latitude: Double, longitude: Double): String? {
        val geocoder = Geocoder(InjectUtils.appContext, Locale.ENGLISH)
        var result: String? = null
        try {
            val list: List<Address>? = geocoder.getFromLocation(latitude, longitude, 1)
            if (list != null && list.isNotEmpty()) {
                val address: Address = list[0]
                result = address.getAddressLine(0).toString() + ", " + address.locality
                Log.d("ReverseGeocode", "ADDRESS $result")
            }
        } catch (e: IOException) {
            Log.d("ReverseGeocode", "Impossible to connect to Geocoder", e)
        }
        return result
    }


}