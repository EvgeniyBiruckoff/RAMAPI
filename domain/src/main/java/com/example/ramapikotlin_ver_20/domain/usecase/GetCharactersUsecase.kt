package com.example.ramapikotlin_ver_20.domain.usecase

import androidx.paging.PagingData
import com.example.ramapikotlin_ver_20.domain.Repository
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import kotlinx.coroutines.flow.Flow

class GetCharactersUsecase(private val repository: Repository) {
    fun execute(): Flow<PagingData<RAMCharacter>> {
        return repository.getCharacters()
    }
}