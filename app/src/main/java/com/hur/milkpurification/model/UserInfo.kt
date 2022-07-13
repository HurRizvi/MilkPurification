package com.hur.milkpurification.model

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class UserInfo(
    var milkDepthInInches : Int?
)
