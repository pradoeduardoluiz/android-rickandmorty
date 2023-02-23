package br.com.pradoeduardoluiz.rickandmortyapp.domain.models

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginModel,
    val location: LocationModel,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
