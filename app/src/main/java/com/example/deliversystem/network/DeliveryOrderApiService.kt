package com.example.deliversystem.network

import com.example.deliversystem.models.GoodsProductModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mock-api-mobile.dev.lalamove.com/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DeliveryOrderApiService{

    @GET("deliveries")
    suspend fun getOrders() : List<GoodsProductModel>
}

object DeliverApi{
    val deliveryOrderApiSerive : DeliveryOrderApiService by lazy {
        retrofit.create(DeliveryOrderApiService::class.java)
    }
}