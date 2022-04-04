package com.hur.milkpurification.storage

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hur.milkpurification.model.LoginResponse
import com.hur.milkpurification.utils.Constant.PreferenceKeys.FIREBASE_TOKEN
import com.hur.milkpurification.utils.Constant.PreferenceKeys.LOGIN_RESPONSE
import org.apache.commons.lang3.StringUtils


/**
 * Created by jforjari@gmail.com.
 * Email: ingenious.hur@gmail.com
 */
object AppPreferences
{
    var loginData: LoginResponse?
        get() {
            val data = Prefs.getString(LOGIN_RESPONSE, StringUtils.EMPTY)
            if (data.isNotEmpty()) {
                return Gson().fromJson(data, object : TypeToken<LoginResponse>() {}.type)
            }
            return null
        }
        set(loginData) = Prefs.putString(LOGIN_RESPONSE, Gson().toJson(loginData))


    var firebaseToken: String
        /**
         * [FIREBASE_TOKEN] return firebase token
         */
        get() = Prefs.getString(FIREBASE_TOKEN, StringUtils.EMPTY) as String
        /**
         * set [FIREBASE_TOKEN] value
         */
        set(firebaseToken) = Prefs.putString(FIREBASE_TOKEN, firebaseToken)
//    /**
//     * Tasker location data
//     */
//    var userLocation: LocationModel?
//        get() {
//            val data = Prefs.getString(USER_LOCATION, StringUtils.EMPTY) as String
//            if (data.isNotEmpty()) {
//                return Gson().fromJson(data, object : TypeToken<LocationModel>() {}.type)
//            }
//            return null
//        }
//        set(userLocation) = Prefs.putString(USER_LOCATION, Gson().toJson(userLocation))
}