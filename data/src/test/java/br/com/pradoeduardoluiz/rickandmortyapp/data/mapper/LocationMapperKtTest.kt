package br.com.pradoeduardoluiz.rickandmortyapp.data.mapper

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.LocationModel
import org.junit.Assert
import org.junit.Test

internal class LocationMapperKtTest {

    @Test
    fun `should map LocationResponse to model`() {
        val original = CharacterResponse.Location(
            name = "name",
            url = "url"
        )
        val expected = LocationModel(
            name = "name",
            url = "url"
        )
        val actual = original.toModel()
        Assert.assertEquals(expected, actual)
    }

}
