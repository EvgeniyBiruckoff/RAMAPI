package com.example.ramapikotlin_ver_20.di

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.ramapikotlin_ver_20.domain.models.Episode
import com.example.ramapikotlin_ver_20.domain.models.RAMCharacter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class AndroidModule {
    @Provides
    fun provideViewModelLiveData(): MutableLiveData<RAMCharacter?>{
        return MutableLiveData<RAMCharacter?>()
    }
    @Provides
    fun provideViewModelLiveDataEpisodesIds(): MutableLiveData<Bundle>{
        return MutableLiveData<Bundle>()
    }
    @Provides
   fun provideStringBuilder():StringBuilder{
       return StringBuilder()
   }
    @Provides
    fun provideBundle(): Bundle{
        return Bundle()
    }
    @Provides
    fun provideViewModelLiveDataString():MutableLiveData<String>{
        return MutableLiveData("")
    }
    @Provides
    fun provideViewModelLiveDataListEpisode(): MutableLiveData<List<Episode>?>{
        return MutableLiveData<List<Episode>?>()
    }

}