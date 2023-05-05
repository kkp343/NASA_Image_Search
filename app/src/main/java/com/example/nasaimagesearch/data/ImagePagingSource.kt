package com.example.nasaimagesearch.data

import androidx.paging.PagingSource
import com.example.nasaimagesearch.api.NasaApi
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class ImagePagingSource(
    private val nasaApi: NasaApi,
    private val query: String
) : PagingSource<Int, NasaImage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NasaImage> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
        val response = nasaApi.searchImages(
            query
        )
        val photos = response.collection.items

            LoadResult.Page(
                data = photos,
                prevKey = if (photos.isEmpty() || position == STARTING_PAGE_INDEX) null else position -1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}