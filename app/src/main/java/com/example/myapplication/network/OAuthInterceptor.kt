package com.example.myapplication.network

import okhttp3.Interceptor

class OAuthInterceptor (private val headerName: String, private val value: String):
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header(headerName, value).build()
        return chain.proceed(request)
    }

}
