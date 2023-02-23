package br.com.pradoeduardoluiz.rickandmortyapp.data.remote

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.PaginationResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface CharacterService {

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterResponse

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): PaginationResponse<CharacterResponse>
}
