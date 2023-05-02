package com.example.nasaimagesearch.ui.gallery

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.nasaimagesearch.data.NasaImageRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: NasaImageRepository,
    @Assisted state: SavedStateHandle
    ): ViewModel() {

    private val currentQuery =  state.getLiveData(CURRENT_QUERY,DEFAULT_QUERY )

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "mars"
    }

//        val photos = repository.getSearchResults(
//            "apollo 11", "moon landing", "image")

}