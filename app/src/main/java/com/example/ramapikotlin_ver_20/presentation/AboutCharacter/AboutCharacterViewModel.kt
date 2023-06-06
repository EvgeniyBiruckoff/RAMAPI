package com.example.ramapikotlin_ver_20.presentation.AboutCharacter

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import com.example.ramapikotlin_ver_20.domain.usecase.GetCharacterByIdUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutCharacterViewModel  @Inject constructor(
    private val getCharacterByIdUsecase: GetCharacterByIdUsecase,
    val viewModelLiveData:MutableLiveData<RAMCharacter?>,
    val viewModelLiveDataEpisodesIds:MutableLiveData<Bundle>,
    private val builder:StringBuilder,
    private val bundle:Bundle
): ViewModel() {

    fun getCharacterById(id:Int){
        getCharacterByIdUsecase.execute(id).subscribe({it->
            it.episode.forEach(){it->builder.append(it.filter { it.isDigit() }+",")}
            bundle.putString("ids",builder.toString())
            viewModelLiveData.value = it
            viewModelLiveDataEpisodesIds.value =bundle},{viewModelLiveData.value = null})

    }


}