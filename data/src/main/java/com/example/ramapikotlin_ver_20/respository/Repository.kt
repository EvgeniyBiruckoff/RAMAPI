package com.example.ramapikotlin_ver_20.respository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.ramapikotlin_ver_20.domain.Repository
import com.example.ramapikotlin_ver_20.respository.web.GetCharactersRxPagingSource
import com.example.ramapikotlin_ver_20.respository.web.RetrofitInstance
import com.example.ramapikotlin_ver_20.repository.models.Page
import com.example.ramapikotlin_ver_20.domain.models.Episode
import com.example.ramapikotlin_ver_20.domain.models.Location
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository: Repository {

    override fun getUserById(id: Int): Single<RAMCharacter> {
        return RetrofitInstance.create().getCharacterById(id).map { it->RAMCharacter(
            episode = it.episode,
            name = it.name,
            id = it.id,
            status = it.status,
            image = it.image,
            species = it.species,
            location = Location(it.location.name,it.location.url)
        ) }.subscribeOn(
            Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread())

    }

    override fun getEpisodes(episode:String): Single<List<Episode>> {
        return RetrofitInstance.create().getEpisodes(episode).flatMapIterable{it->it}.map { it->
            Episode(
                name = it.name,
                air_date = it.air_date,
                id = it.id
            )
        }.toList().subscribeOn(
            Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread())

    }
    fun getByPage(page:Int):Single<Page>  {
        return RetrofitInstance.create().getByPage(page).subscribeOn(
          Schedulers.io()).observeOn(
           AndroidSchedulers.mainThread())
    }
    override fun getCharacters(): Flow<PagingData<RAMCharacter>> {
        return Pager(
                config = PagingConfig(
                pageSize =1,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GetCharactersRxPagingSource(this)
            }
        ).flow.map { it.map {
                it->RAMCharacter(
            episode = it.episode,
            name = it.name,
            id = it.id,
            status = it.status,
            image = it.image,
            species = it.species,
            location = Location(it.location.name,it.location.url)
        )

        }
        } }
    }

