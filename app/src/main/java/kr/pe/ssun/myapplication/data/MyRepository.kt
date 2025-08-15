package kr.pe.ssun.myapplication.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kr.pe.ssun.myapplication.model.Pokemon
import kr.pe.ssun.myapplication.network.MyNetworkDataSource
import kr.pe.ssun.myapplication.network.model.externalModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor(
    private val network: MyNetworkDataSource
) {
    suspend fun getPokemonList(
        limit: Int = 20,
        offset: Int
    ): Flow<List<Pokemon>> = flow {
        emit(network.getPokemonList(limit, offset).results.map {
          it.externalModel()
        })
    }
}