package com.example.weather_app.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weather_app.data.db.city.*
import com.example.weather_app.data.db.weather.DbCurrent
import com.example.weather_app.data.db.weather.WeatherDataBaseDao
import dagger.Module
import dagger.Provides

const val DB_NAME = "project_database"
const val DB_VERSION = 1

@Database(
    entities = [
        DbCurrent::class,
        DbCity::class,
        DbState::class,
        DbCountry::class,
        DbSavedCity::class
    ],
    version = DB_VERSION,
    exportSchema = false
)
abstract class ProjectDataBase : RoomDatabase() {

    abstract val weatherDataBaseDao: WeatherDataBaseDao
    abstract val cityDataBaseDao: CityDataBaseDao

    companion object{
        @Volatile
        private val INSTANCE: ProjectDataBase? = null

        fun getInstance(context: Context): ProjectDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProjectDataBase::class.java,
                        DB_NAME
                    )
                        .createFromAsset("cities.db")
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}