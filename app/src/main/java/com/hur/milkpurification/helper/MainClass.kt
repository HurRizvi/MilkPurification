package com.hur.milkpurification.helper

import android.app.Application
import android.content.ContextWrapper
import com.hur.milkpurification.koin.module.NetworkModule
import com.hur.milkpurification.koin.module.RepositoryModule
import com.hur.milkpurification.koin.module.ViewModelModule
import com.hur.milkpurification.storage.Prefs
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * Created by jforjari@gmail.com.
 * Email: ingenious.hur@gmail.com
 */
class MainClass: Application()
{
    private val appModules = listOf(
        NetworkModule,
        RepositoryModule,
        ViewModelModule
    )

    override fun onCreate() {
        super.onCreate()

        /**
         * Initialize or Start Koin
         */
        startKoin {
            androidLogger(Level.INFO)
            androidContext(this@MainClass)
            modules(appModules)
        }

        /**
         * Initialize the Prefs class
         */
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }
}