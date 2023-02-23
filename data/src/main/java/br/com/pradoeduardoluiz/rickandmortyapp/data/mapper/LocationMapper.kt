package br.com.pradoeduardoluiz.rickandmortyapp.data.mapper

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.CharacterModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.LocationModel

internal fun CharacterResponse.Location.toModel() = LocationModel(
    name = name,
    url = url
)
