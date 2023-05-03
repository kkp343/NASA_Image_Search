package com.example.nasaimagesearch.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.nasaimagesearch.api.NasaApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NasaImageRepository @Inject constructor(private val nasaApi: NasaApi) {

    fun getSearchResults(
        query: String
    ) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                ImagePagingSource(
                    nasaApi, query
                )
            }
        ).liveData
}