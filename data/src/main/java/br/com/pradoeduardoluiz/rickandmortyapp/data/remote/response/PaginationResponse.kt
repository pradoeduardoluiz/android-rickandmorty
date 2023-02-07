package br.com.pradoeduardoluiz.rickandmortyapp.data.remote.response


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PaginationResponse<T>(
    @Json(name = "info")
    val info: Info,
    @Json(name = "results")
    val items: List<T>
) {
    @JsonClass(generateAdapter = true)
    data class Info(
        @Json(name = "count")
        val count: Int,
        @Json(name = "pages")
        val pages: Int,
        @Json(name = "next")
        val next: String?,
        @Json(name = "prev")
        val prev: String?
    )
}
