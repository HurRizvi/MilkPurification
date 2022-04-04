package com.hur.milkpurification

import android.content.Intent
import android.os.Parcelable
import java.io.Serializable

/**
 * Created by Muhammad Dilawar Khan Azeemi on 10/21/2021
 * Email: ingenious.dilawar@gmail.com
 */
fun Intent.putExtra(intentKey: String, intentValue: Any?) {
    when (intentValue) {
        is Boolean -> putExtra(intentKey, intentValue)
        is Int -> putExtra(intentKey, intentValue)
        is Float -> putExtra(intentKey, intentValue)
        is Double -> putExtra(intentKey, intentValue)
        is Long -> putExtra(intentKey, intentValue)
        is String -> putExtra(intentKey, intentValue)
        is Serializable -> putExtra(intentKey, intentValue)
        is Parcelable -> putExtra(intentKey, intentValue)
    }
}