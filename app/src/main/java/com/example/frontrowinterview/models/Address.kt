package com.example.frontrowinterview.models


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("geo")
    var geo: Geo? = null,
    @SerializedName("street")
    var street: String? = null,
    @SerializedName("suite")
    var suite: String? = null,
    @SerializedName("zipcode")
    var zipcode: String? = null
)