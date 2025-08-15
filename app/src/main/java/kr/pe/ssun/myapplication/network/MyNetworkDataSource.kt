package kr.pe.ssun.myapplication.network

import kr.pe.ssun.myapplication.network.model.NetworkNamedAPIResourceList
import kr.pe.ssun.myapplication.network.model.NetworkPokemon

interface MyNetworkDataSource {
    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): NetworkNamedAPIResourceList<NetworkPokemon>
}