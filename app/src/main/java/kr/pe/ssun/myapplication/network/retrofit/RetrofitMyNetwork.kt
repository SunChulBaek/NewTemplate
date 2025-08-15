package kr.pe.ssun.myapplication.network.retrofit

import kr.pe.ssun.myapplication.network.MyNetworkDataSource
import kr.pe.ssun.myapplication.network.model.NetworkNamedAPIResourceList
import kr.pe.ssun.myapplication.network.model.NetworkPokemon
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

interface RetrofitMyNetworkApi {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int
    ): NetworkNamedAPIResourceList<NetworkPokemon>
}

@Singleton
class RetrofitMyNetwork @Inject constructor(
    private val networkApi: RetrofitMyNetworkApi
) : MyNetworkDataSource {

    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): NetworkNamedAPIResourceList<NetworkPokemon> = networkApi.getPokemonList(limit, offset)
}