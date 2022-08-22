package com.example.frontrowinterview.api

import com.example.frontrowinterview.models.Users
import com.example.frontrowinterview.models.UsersItem
import retrofit2.Call
import retrofit2.http.GET

interface CallAPI {
    @GET("users")
     fun getUsers(
    ): Call<List<UsersItem>>
}