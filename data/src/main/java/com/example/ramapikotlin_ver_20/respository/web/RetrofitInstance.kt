package com.example.ramapikotlin_ver_20.respository.web

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {

        var BASE_URL = "https://rickandmortyapi.com"

        fun create() : RetrofitInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(
                    RxJava3CallAdapterFactory.create())

                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RetrofitInterface::class.java)

        }
    }
}