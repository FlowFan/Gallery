package com.example.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn

class GalleryViewModel : ViewModel() {
    val pagingData = PixabayRepository.getPagingData().cachedIn(viewModelScope).asLiveData()
}