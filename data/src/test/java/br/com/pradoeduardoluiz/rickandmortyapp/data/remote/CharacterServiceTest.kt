package br.com.pradoeduardoluiz.rickandmortyapp.data.remote

import br.com.pradoeduardoluiz.rickandmortyapp.data.enqueueResponse
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.CharacterResponse
import br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response.PaginationResponse
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class CharacterServiceTest {

    lateinit var mockWebServer: MockWebServer

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    @Before
    fun `should init mock server`() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
    }

    @After
    fun `should destroy mock server`() {
        mockWebServer.shutdown()
    }

    @Test
    fun `should hit endpoints with expected parameters`() = runBlocking {
        mockWebServer.enqueueResponse("characters.json", 200)

        val retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()

        val expected = PaginationResponse(
            info = PaginationResponse.Info(
                count = 826,
                pages = 42,
                next = "https://rickandmortyapi.com/api/character/?page=2",
                prev = null
            ),
            items = listOf(
                CharacterResponse(
                    id = 1,
                    name = "Rick Sanchez",
                    status = "Alive",
                    species = "Human",
                    type = "",
                    gender = "Male",
                    origin = CharacterResponse.Origin(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/1"
                    ),
                    location = CharacterResponse.Location(
                        name = "Earth",
                        url = "https://rickandmortyapi.com/api/location/20"
                    ),
                    image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                    episode = listOf(
                        "https://rickandmortyapi.com/api/episode/1",
                        "https://rickandmortyapi.com/api/episode/2"
                    ),
                    url = "https://rickandmortyapi.com/api/character/1",
                    created = "2017-11-04T18:48:46.250Z"
                )
            )
        )

        val service: CharacterService = retrofit.create(CharacterService::class.java)
        val actual = service.getCharacters(page = 1)
        assertEquals(expected, actual)
    }
}
