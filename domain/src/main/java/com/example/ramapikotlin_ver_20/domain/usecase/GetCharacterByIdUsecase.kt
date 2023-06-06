package com.example.ramapikotlin_ver_20.domain.usecase

import com.example.ramapikotlin_ver_20.domain.Repository
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter

import io.reactivex.rxjava3.core.Single

class GetCharacterByIdUsecase(private val repository: Repository) {
    fun execute(id: Int): Single<RAMCharacter> {
       return repository.getUserById(id)
    }
}