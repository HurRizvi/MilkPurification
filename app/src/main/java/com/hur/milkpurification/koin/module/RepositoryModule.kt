package com.hur.milkpurification.koin.module

import com.hur.milkpurification.repository.GeneralRepository
import org.koin.dsl.module

/**
 * Created by Muhammad Dilawar Khan Azeemi on 10/12/2021.
 * Email: ingenious.dilawar@gmail.com
 */
val RepositoryModule = module {

    /**
     * Define a Singleton of General Repository
     * Get Single instance of General Repository
     */
    single {
        GeneralRepository()
    }
}