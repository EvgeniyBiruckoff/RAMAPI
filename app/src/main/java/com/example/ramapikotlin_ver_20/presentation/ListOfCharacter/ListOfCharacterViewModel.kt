package com.example.ramapikotlin_ver_20.presentation.ListOfCharacter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import com.example.ramapikotlin_ver_20.domain.usecase.GetCharactersUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*

import javax.inject.Inject

@HiltViewModel
class ListOfCharacterViewModel  @Inject constructor(
    private var viewModelLiveData:MutableLiveData<String>,
    private val getCharactersUsecase: GetCharactersUsecase
): ViewModel() {
    val usersFlow: Flow<PagingData<RAMCharacter>>
    init {
    usersFlow = viewModelLiveData.asFlow().debounce(500).flatMapLatest { getCharactersUsecase.execute()
    }.cachedIn(viewModelScope)
    }
}