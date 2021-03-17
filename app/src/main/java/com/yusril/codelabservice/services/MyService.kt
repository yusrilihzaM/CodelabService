package com.yusril.codelabservice.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class MyService : Service() {
    companion object {
        internal val TAG = MyService::class.java.simpleName
    }

    private val serviceJob = Job()

    private val serviceScope = CoroutineScope(Dispatchers.Main + serviceJob)
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Log.d(TAG, "Service dijalankan...");
        serviceScope.launch {
            delay(3000)
            stopSelf()//berfungsi untuk  memberhentikan atau mematikan MyService dari sistem Android.
            Log.d(TAG, "Service dihentikan")
        }
        return START_STICKY
    }


}