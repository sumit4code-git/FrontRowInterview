package com.example.frontrowinterview.models


import com.google.gson.annotations.SerializedName

data class UsersItem(
    @SerializedName("address")
    var address: Address? = null,
    @SerializedName("company")
    var company: Company? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("phone")
    var phone: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("website")
    var website: String? = null
)