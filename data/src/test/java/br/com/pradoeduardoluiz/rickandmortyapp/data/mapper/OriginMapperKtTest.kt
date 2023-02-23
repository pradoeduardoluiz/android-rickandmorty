package br.com.pradoeduardoluiz.rickandmortyapp.data.mapper

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.OriginModel
import org.junit.Assert
import org.junit.Test

internal class OriginMapperKtTest {
    @Test
    fun `should map OriginResponse to model`() {
        val original = CharacterResponse.Origin(
            name = "name",
            url = "url"
        )
        val expected = OriginModel(
            name = "name",
            url = "url"
        )
        val actual = original.toModel()
        Assert.assertEquals(expected, actual)
    }
}
