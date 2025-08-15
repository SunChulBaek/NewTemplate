package kr.pe.ssun.myapplication.network.model

data class NetworkNamedAPIResourceList<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<T>
)