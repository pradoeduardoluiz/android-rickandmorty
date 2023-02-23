package br.com.pradoeduardoluiz.rickandmortyapp.domain.repositories

import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.CharacterModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.PaginationModel

interface CharacterRepository {
    suspend fun getCharacter(id: Int): CharacterModel
    suspend fun getCharacters(page: Int): PaginationModel<CharacterModel>
}
