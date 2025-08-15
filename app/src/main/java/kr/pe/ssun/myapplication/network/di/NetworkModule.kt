package kr.pe.ssun.myapplication.network.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.pe.ssun.myapplication.network.MyNetworkDataSource
import kr.pe.ssun.myapplication.network.retrofit.RetrofitMyNetwork
import kr.pe.ssun.myapplication.network.retrofit.RetrofitMyNetworkApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideBaseUrl() = "https://pokeapi.co/api/v2/"

    @Singleton
    @Provides
    fun provideNetworkApi(
        retrofit: Retrofit
    ) = retrofit.create(RetrofitMyNetworkApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(
        baseUrl: String,
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ) = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Singleton
    @Provides
    fun provideLoggingInterceptor() = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}

@Module
@InstallIn(SingletonComponent::class)
interface SsunNetworkModule2 {
    @Singleton
    @Binds
    fun bindRetrofitSsunNetwork(
        network: RetrofitMyNetwork
    ): MyNetworkDataSource
}