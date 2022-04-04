package com.hur.milkpurification.utils

/**
 * Created by jforjari@gmail.com.
 * Email: ingenious.hur@gmail.com
 */
object Constant {
    const val SPLASH_TIME: Long = 3000
    var LATITUDE = "LATITUDE"
    var LONGITUDE = "LONGITUDE"
    const val USER_LOCATION = "USER_LOCATION"
    const val GOOGLE_MAP_API = "AIzaSyAQg6fxOc3g-oCdnKBNlzxrQ7tn8tR5Fnk"

    object PreferenceKeys {
        const val LOGIN_RESPONSE = "LOGIN_RESPONSE"
        const val REGISTER_RESPONSE = "REGISTER_RESPONSE"

        const val IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN"
        const val IS_USER_LOG_OUT = "IS_USER_LOG_OUT"
        const val USER_ID = "USER_ID"


        const val USER_NAME = "USER_NAME"
        const val USER_IMAGE = "USER_IMAGE"
        const val FIREBASE_TOKEN = "FIREBASE_TOKEN"
        const val TOKEN = "TOKEN"
    }

    object RetrofitConstants {
        const val RETROFIT_METHOD_POST = "post"
        const val RETROFIT_METHOD_GET = "get"
    }

    object ErrorMessage {
        const val REQUIRED = "Required"
    }

    object IntentKeys {

    }

}