package com.example.ramapikotlin_ver_20.domain.usecase

import com.example.ramapikotlin_ver_20.domain.Repository
import com.example.ramapikotlin_ver_20.domain.models.Episode

import io.reactivex.rxjava3.core.Single

class GetListOfEpisodesByIdsUsecase(private val repository: Repository) {
    fun execute(ids: String): Single<List<Episode>>{
       return repository.getEpisodes(ids)
    }
}