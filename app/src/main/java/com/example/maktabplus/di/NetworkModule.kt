package com.example.maktabplus.di

import com.example.maktabplus.data.model.Image
import com.example.maktabplus.data.source.remote.api.PictureSumApi
import com.example.maktabplus.data.source.remote.api.deserializer.ImageDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://picsum.photos/"

    @Singleton
    @Provides
    fun provideRetrofit(
        client: OkHttpClient,
        gson: Gson
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder()
        .registerTypeAdapter(
            object : TypeToken<Image>() {}.type,
            ImageDeserializer()
        )
        .create()

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @LoggingInterceptor
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Singleton
    @Provides
    fun providePictureSumApi(retrofit: Retrofit): PictureSumApi =
        provideApi(retrofit)

    inline fun <reified T> provideApi(retrofit: Retrofit) =
        retrofit.create<T>()
}