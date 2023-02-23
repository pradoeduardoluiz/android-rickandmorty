package br.com.pradoeduardoluiz.rickandmortyapp.data.repository

import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.CharacterService
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.PaginationResponse
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.CharacterModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.LocationModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.OriginModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.models.PaginationModel
import br.com.pradoeduardoluiz.rickandmortyapp.domain.repositories.CharacterRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


internal class CharacterRepositoryImplTest {

    private val characterService = mockk<CharacterService>()
    private lateinit var characterRepository: CharacterRepository

    @Before
    @Test
    fun `test subject must not be null`() {
        characterRepository = CharacterRepositoryImpl(
            characterService = characterService
        )
        assertNotNull(characterRepository)
    }

    @Test
    fun `should get character by id`() = runBlocking {
        val id = 1
        val response = CharacterResponse(
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

        val model = CharacterModel(
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

        coEvery { characterService.getCharacter(id = id) } returns response

        val actual = characterRepository.getCharacter(id = id)
        assertEquals(actual, model)

        coVerify(exactly = 1) { characterService.getCharacter(id = id) }
        confirmVerified(characterService)
    }

    @Test
    fun `should get characters pagination`() = runBlocking {
        val page = 1
        val response = PaginationResponse(
            info = PaginationResponse.Info(
                count = 1,
                pages = 1,
                next = null,
                prev = null
            ), items = listOf(
                CharacterResponse(
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
            )
        )

        val model = PaginationModel(
            info = PaginationModel.Info(
                count = 1,
                pages = 1,
                next = null,
                prev = null
            ), items = listOf(
                CharacterModel(
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
            )
        )

        coEvery { characterService.getCharacters(page = page) } returns response

        val actual = characterRepository.getCharacters(page = page)
        assertEquals(actual, model)

        coVerify(exactly = 1) { characterService.getCharacters(page = page) }
        confirmVerified(characterService)
    }
}
