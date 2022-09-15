package com.example.weather_app.di

import android.app.Application
import com.example.weather_app.data.api.RetrofitApi
import com.example.weather_app.data.db.ProjectDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun projectDatabase(app: Application) = ProjectDataBase.getInstance(app)

    @Provides
    @Singleton
    fun cityDao(db: ProjectDataBase) = db.cityDataBaseDao

    @Provides
    @Singleton
    fun weatherDao(db: ProjectDataBase) = db.weatherDataBaseDao

    @Provides
    @Singleton
    fun retrofitApi(retrofit: Retrofit) = RetrofitModule()

}