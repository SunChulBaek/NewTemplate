package kr.pe.ssun.myapplication.network.model

import kr.pe.ssun.myapplication.model.Pokemon

data class NetworkPokemon(
    val name: String,
    val url: String
)

fun NetworkPokemon.externalModel() = Pokemon(
    id = this.url.substring(0, this.url.length - 1).split("/").last().toInt(),
    name = this.name
)