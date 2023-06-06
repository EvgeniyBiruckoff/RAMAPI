package com.example.ramapikotlin_ver_20.domain


import androidx.paging.PagingData
import com.example.ramapikotlin_ver_20.domain.models.Episode
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getUserById(id: Int): Single<RAMCharacter>
    fun getEpisodes(episode:String): Single<List<Episode>>
    fun getCharacters(): Flow<PagingData<RAMCharacter>>
}