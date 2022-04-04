package com.hur.milkpurification.koin

import android.app.Application
import com.hur.milkpurification.network.SoService
import com.hur.milkpurification.repository.GeneralRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Muhammad Dilawar Khan Azeemi on 10/14/2021.
 * Email: ingenious.dilawar@gmail.com
 */
object InjectUtils : KoinComponent
{
    /**
     * Get Single instance of Application Context
     */
    val appContext: Application by inject()

    /**
     * Get Single instance of Retrofit WEB API Service
     */
    val getRetrofit: SoService by inject()

    /**
     * Get Single instance of GeneralRepository
     */
    val getGeneralRepository : GeneralRepository by inject()
}