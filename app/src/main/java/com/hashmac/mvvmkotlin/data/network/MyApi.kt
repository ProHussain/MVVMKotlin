package com.hashmac.mvvmkotlin.data.network

import com.hashmac.mvvmkotlin.ui.home.model.Model
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {
    @GET("search?q=milky%20way&media_type=image&year_start=2017&year_end=2019")
    fun nasaResponse() : Call<Model>

    companion object {
        operator fun invoke() : MyApi {
            return Retrofit.Builder()
                .baseUrl("https://images-api.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}