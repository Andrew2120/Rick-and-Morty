package com.andrew.rickandmorty.domain

import com.andrew.rickandmorty.domain.models.Character
interface RMClient {
    suspend fun getCharacters(): List<Character>
}

