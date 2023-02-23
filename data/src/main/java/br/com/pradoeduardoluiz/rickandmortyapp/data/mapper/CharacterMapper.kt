package br.com.pradoeduardoluiz.rickandmortyapp.data.mapper

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.PaginationResponse
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.CharacterModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.PaginationModel

internal fun PaginationResponse<CharacterResponse>.toModel() = PaginationModel<CharacterModel>(
    info = PaginationModel.Info(
        count = info.count,
        pages = info.pages,
        next = info.next,
        prev = info.prev
    ),
    items = items.map { it.toModel() }
)

internal fun CharacterResponse.toModel() = CharacterModel(
    id = id,
    name = name,
    status = status,
    species = species,
    type = type,
    gender = gender,
    origin = origin.toModel(),
    location = location.toModel(),
    image = image,
    episode = episode,
    url = url,
    created = created
)
