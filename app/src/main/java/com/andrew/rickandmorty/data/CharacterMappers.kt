package com.andrew.rickandmorty.data

import com.andrew.CharactersQuery
import com.andrew.rickandmorty.domain.models.Character


fun CharactersQuery.Result.toCharacter(): Character {
    return Character(
        id = id ?: "",
        name = name ?: "",
        image = image ?: "",
        species = species ?: ""
    )

}