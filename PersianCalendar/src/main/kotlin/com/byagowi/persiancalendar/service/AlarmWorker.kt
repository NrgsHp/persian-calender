package com.byagowi.persiancalendar.service

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.byagowi.persiancalendar.KEY_EXTRA_PRAYER_KEY
import com.byagowi.persiancalendar.utils.startAthan
import kotlinx.coroutines.coroutineScope

class AlarmWorker(private val context: Context, private val workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        startAthan(context, workerParams.inputData.getString(KEY_EXTRA_PRAYER_KEY) ?: "FAJR")
        Result.success()
    }
}