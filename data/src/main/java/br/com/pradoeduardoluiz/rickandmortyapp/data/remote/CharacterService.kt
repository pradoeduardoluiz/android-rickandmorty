package br.com.pradoeduardoluiz.rickandmortyapp.data.remote

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.PaginationResponse
import retrofit2.http.GET

internal interface CharacterService {
    @GET("character")
    suspend fun getCharacters(): PaginationResponse<CharacterResponse>
}
