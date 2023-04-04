package com.andrew.rickandmorty.domain.use_cases

import com.andrew.rickandmorty.domain.RMClient
import com.andrew.rickandmorty.domain.models.Character
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val rmClient: RMClient) {

    suspend operator fun invoke(): List<Character> {
        return rmClient.getCharacters().sortedBy {
            it.name
        }
    }
}