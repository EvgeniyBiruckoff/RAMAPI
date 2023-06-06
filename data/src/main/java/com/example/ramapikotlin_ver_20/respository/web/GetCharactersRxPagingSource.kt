package com.example.ramapikotlin_ver_20.respository.web

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.example.ramapikotlin_ver_20.repository.models.RAMCharacter

import com.example.ramapikotlin_ver_20.respository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class GetCharactersRxPagingSource(private val repository: Repository) : RxPagingSource<Int, RAMCharacter>() {
    override fun getRefreshKey(state: PagingState<Int, RAMCharacter>): Int? {
        return 1

    }

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, RAMCharacter>> {

        var position:Int = params.key?:1
        return repository.getByPage(position)
            .subscribeOn(Schedulers.io())
            .map<LoadResult<Int, RAMCharacter>> { result ->
                LoadResult.Page(
                    data = result.results,
                    prevKey = if(position>1) position -1 else null,
                    nextKey = position +1
                )

            }.onErrorReturn { LoadResult.Error(it) }.observeOn(AndroidSchedulers.mainThread())
    }


}