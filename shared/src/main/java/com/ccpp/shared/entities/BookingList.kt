package com.ccpp.shared.entities

import com.google.gson.annotations.SerializedName

data class BookingList(@SerializedName("imgIcon") val imgIcon: Int?,
                       @SerializedName("name") val name: String? = "")
{

}