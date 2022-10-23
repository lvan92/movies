package com.example.myapplication.network

import com.example.myapplication.common.Header
import com.example.myapplication.common.Variable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface  RetrofitInstance {
    companion object {
        fun getRetrofitInstance(): Retrofit {
            val client =  OkHttpClient.Builder()
                .addInterceptor(OAuthInterceptor(Header.KEY, Variable.API_KEY))
                .addInterceptor(OAuthInterceptor( Header.HOST, Variable.API_HOST))
                .build()
            return Retrofit.Builder()
                .baseUrl(Variable.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}