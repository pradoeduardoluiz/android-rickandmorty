package br.com.pradoeduardoluiz.rickandmortyapp.data.mapper

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.CharacterModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.OriginModel

internal fun CharacterResponse.Origin.toModel() = OriginModel(
    name = name,
    url = url
)
