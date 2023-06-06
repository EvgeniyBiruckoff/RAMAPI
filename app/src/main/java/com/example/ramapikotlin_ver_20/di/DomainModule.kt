package com.example.ramapikotlin_ver_20.di


import com.example.ramapikotlin_ver_20.domain.Repository
import com.example.ramapikotlin_ver_20.domain.usecase.GetCharacterByIdUsecase
import com.example.ramapikotlin_ver_20.domain.usecase.GetCharactersUsecase
import com.example.ramapikotlin_ver_20.domain.usecase.GetListOfEpisodesByIdsUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetCharacterByIdUsecase(repository: Repository):GetCharacterByIdUsecase{
       return GetCharacterByIdUsecase(repository)
    }
    @Provides
    fun provideGetListOfEpisodesByIds(repository: Repository):GetListOfEpisodesByIdsUsecase{
        return GetListOfEpisodesByIdsUsecase(repository)
    }
    @Provides
    fun provideGetCharacters(repository: Repository):GetCharactersUsecase{
        return GetCharactersUsecase(repository)
    }

}