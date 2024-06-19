package com.example.rickandmortyandroid.di

import com.example.rickandmortyandroid.common.Constants
import com.example.rickandmortyandroid.features.characters.data.data_sources.remote.RickAndMortyApi
import com.example.rickandmortyandroid.features.characters.data.repository.CharacterRepositoryImpl
import com.example.rickandmortyandroid.features.characters.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(api: RickAndMortyApi): CharacterRepository {
        return CharacterRepositoryImpl(api)
    }
}