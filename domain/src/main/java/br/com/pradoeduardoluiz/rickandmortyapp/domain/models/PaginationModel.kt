package br.com.pradoeduardoluiz.rickandmortyapp.domain.models


data class PaginationModel<T>(
    val info: Info,
    val items: List<T>
) {
    data class Info(
        val count: Int,
        val pages: Int,
        val next: String?,
        val prev: String?
    )
}
