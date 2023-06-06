package com.example.ramapikotlin_ver_20.respository.web

import com.example.ramapikotlin_ver_20.repository.models.Page
import com.example.ramapikotlin_ver_20.repository.models.Episode
import com.example.ramapikotlin_ver_20.repository.models.RAMCharacter
import io.reactivex.rxjava3.core.Observable

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("/api/character/{ids}")
    fun getCharacterById(@Path("ids") id: Int) : Single<RAMCharacter>

    @GET("/api/character")
    fun getByPage(@Query("page") page: Int): Single<Page>

    @GET("/api/episode/{ids}")
    fun getEpisodes(@Path("ids") ids: String): Observable<List<Episode>>

}