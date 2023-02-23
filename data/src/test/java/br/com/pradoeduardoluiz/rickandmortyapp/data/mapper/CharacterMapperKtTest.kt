package br.com.pradoeduardoluiz.rickandmortyapp.data.mapper

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.CharacterModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.LocationModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.OriginModel
import org.junit.Assert.assertEquals
import org.junit.Test

internal class CharacterMapperKtTest {

    @Test
    fun `should map CharacterResponse to model`() {
        val original = CharacterResponse(
            id = 1,
            name = "name",
            status = "status",
            species = "species",
            type = "type",
            gender = "gender",
            origin = CharacterResponse.Origin(
                name = "name", url = "url"
            ),
            location = CharacterResponse.Location(
                name = "name", url = "url"
            ),
            image = "image",
            episode = listOf("episode"),
            url = "url",
            created = "created"
        )
        val expected = CharacterModel(
            id = 1,
            name = "name",
            status = "status",
            species = "species",
            type = "type",
            gender = "gender",
            origin = OriginModel(
                name = "name", url = "url"
            ),
            location = LocationModel(
                name = "name", url = "url"
            ),
            image = "image",
            episode = listOf("episode"),
            url = "url",
            created = "created"
        )

        val actual = original.toModel()
        assertEquals(expected, actual)
    }

}
