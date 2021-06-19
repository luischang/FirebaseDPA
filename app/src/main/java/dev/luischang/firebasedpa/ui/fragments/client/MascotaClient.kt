package dev.luischang.firebasedpa.ui.fragments.client

import dev.luischang.firebasedpa.ui.fragments.interfaces.APIService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object MascotaClient {

    var url = "http://www.kreapps.biz/patitas/"

    private var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(20,TimeUnit.SECONDS)
        .build()

    private fun buildRetrofit() = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: APIService by lazy {
        buildRetrofit().create(APIService::class.java)
    }


}