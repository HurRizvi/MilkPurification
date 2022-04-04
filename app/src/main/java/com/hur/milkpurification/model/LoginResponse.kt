package com.hur.milkpurification.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by jforjari@gmail.com.
 * Email: ingenious.hur@gmail.com
 */
class LoginResponse
{
    @SerializedName("success")
    @Expose
    val success: Boolean? = null

    @SerializedName("message")
    @Expose
    val message: String? = null

    @SerializedName("token")
    @Expose
    val token: String? = null

    @SerializedName("user_id")
    @Expose
    val userId: Int? = null

    @SerializedName("first_name")
    @Expose
    val firstName: String? = null

    @SerializedName("last_name")
    @Expose
    val lastName: String? = null

    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("email")
    @Expose
    val email: String? = null

    @SerializedName("phone")
    @Expose
    val phone: String? = null

    @SerializedName("whatsapp")
    @Expose
    val whatsapp: String? = null

    @SerializedName("ptcl")
    @Expose
    val ptcl: String? = null

    @SerializedName("business_name")
    @Expose
    val businessName: String? = null

    @SerializedName("business_type")
    @Expose
    val businessType: String? = null

    @SerializedName("business_url")
    @Expose
    val businessUrl: String? = null

    @SerializedName("cnic")
    @Expose
    val cnic: String? = null

    @SerializedName("ntn")
    @Expose
    val ntn: String? = null

    @SerializedName("country")
    @Expose
    val country: String? = null

    @SerializedName("city")
    @Expose
    val city: String? = null

    @SerializedName("fcm")
    @Expose
    val fcm: String? = null
}