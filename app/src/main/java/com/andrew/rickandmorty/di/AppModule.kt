package com.andrew.rickandmorty.di

import com.apollographql.apollo3.ApolloClient
import com.andrew.rickandmorty.data.ApolloRMClient
import com.andrew.rickandmorty.domain.RMClient
import com.andrew.rickandmorty.domain.use_cases.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): RMClient {
        return ApolloRMClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: RMClient): GetCharactersUseCase {
        return GetCharactersUseCase(countryClient)
    }

}