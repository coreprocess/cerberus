package com.salmoukas.cerberus.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CheckResultDao {
    @Query("SELECT * FROM check_result WHERE timestamp_utc >= (strftime('%s','now') - :period)")
    fun period(period: Long): List<CheckResult>

    @Query("SELECT * FROM check_result WHERE timestamp_utc >= (strftime('%s','now') - :period)")
    fun periodLive(period: Long): LiveData<List<CheckResult>>

    @Insert
    fun insert(checkResult: CheckResult): Long
}
