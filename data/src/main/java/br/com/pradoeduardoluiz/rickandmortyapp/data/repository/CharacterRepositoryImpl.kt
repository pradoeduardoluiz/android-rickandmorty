package br.com.pradoeduardoluiz.rickandmortyapp.data.repository

import br.com.pradoeduardoluiz.rickandmortyapp.data.mapper.toModel
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.CharacterService
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.CharacterModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.PaginationModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.repositories.CharacterRepository

internal class CharacterRepositoryImpl(
    private val characterService: CharacterService
) : CharacterRepository {

    override suspend fun getCharacter(id: Int): CharacterModel {
        return characterService.getCharacter(id = id).toModel()
    }

    override suspend fun getCharacters(page: Int): PaginationModel<CharacterModel> {
        return characterService.getCharacters(page = page).toModel()
    }
}
