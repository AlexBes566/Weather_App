package com.example.weather_app.data.db.weather

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

interface WeatherDataBaseDao {

    @Insert
    suspend fun insertCurrent(current: DbCurrent)

    @Query(
        """
        SELECT * FROM current_table 
        WHERE cityId = (SELECT id FROM saved_cities WHERE selected)
    """
    )
    fun getCurrentForecast(): Flow<DbCurrent?>

    @Transaction
    suspend fun clearForecast(cityId: Long) {
        clearCurrentForecast(cityId)
    }

    @Transaction
    suspend fun saveForecast(
        cityId: Long,
        current: DbCurrent,
    ) {
        clearForecast(cityId)
        insertCurrent(current)
    }

    @Query("DELETE FROM current_table WHERE cityId = :cityId")
    fun clearCurrentForecast(cityId: Long)
}