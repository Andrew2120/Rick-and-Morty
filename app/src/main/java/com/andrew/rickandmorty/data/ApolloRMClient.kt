package com.andrew.rickandmorty.data

import com.andrew.CharactersQuery
import com.andrew.rickandmorty.domain.RMClient
import com.andrew.rickandmorty.domain.models.Character
import com.apollographql.apollo3.ApolloClient

class ApolloRMClient(
    private val apolloClient: ApolloClient
) : RMClient {


    override suspend fun getCharacters(): List<Character> {
        return apolloClient
            .query(CharactersQuery())
            .execute()
            .data
            ?.characters
            ?.results
            ?.map {
                it?.toCharacter()!!
            }
            ?: emptyList()
    }


}