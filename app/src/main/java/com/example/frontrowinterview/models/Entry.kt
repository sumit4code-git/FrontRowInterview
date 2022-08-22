package com.example.frontrowinterview.models


import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("API")
    var aPI: String? = null,
    @SerializedName("Auth")
    var auth: String? = null,
    @SerializedName("Category")
    var category: String? = null,
    @SerializedName("Cors")
    var cors: String? = null,
    @SerializedName("Description")
    var description: String? = null,
    @SerializedName("HTTPS")
    var hTTPS: Boolean? = null,
    @SerializedName("Link")
    var link: String? = null
)