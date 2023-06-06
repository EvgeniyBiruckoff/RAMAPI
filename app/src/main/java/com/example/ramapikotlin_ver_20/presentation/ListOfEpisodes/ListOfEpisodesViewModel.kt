package com.example.ramapikotlin_ver_20.presentation.ListOfEpisodes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ramapikotlin_ver_20.domain.models.Episode
import com.example.ramapikotlin_ver_20.domain.usecase.GetListOfEpisodesByIdsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListOfEpisodesViewModel @Inject constructor(
    private val getListOfEpisodesByIdsUsecase: GetListOfEpisodesByIdsUsecase,
    var viewModelLiveData: MutableLiveData<List<Episode>?>
): ViewModel() {
    fun getListOfEpisodesById(ids:String){
        getListOfEpisodesByIdsUsecase.execute(ids).subscribe({ it->
            viewModelLiveData.value = it
        },{
            viewModelLiveData.value = null
        })

    }
}