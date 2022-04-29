package com.example.maktabplus.ui.home

import Resource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maktabplus.data.model.Image
import com.example.maktabplus.data.repository.ImageRepository
import com.example.maktabplus.util.emitApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject



class HomeViewModel  constructor(
    private val imageRepository: ImageRepository
) : ViewModel() {

    private val _images = MutableStateFlow<Resource<List<Image>>>(Resource.success(emptyList()))
    val images = _images.asStateFlow()

    init {
        fetchImageList()
    }

    fun fetchImageList() = viewModelScope.launch {
//        imageRepository.getImageList()
//            .catch { cause -> emitApiError(cause) }
//            .collect { images ->
//                _images.value = images
//            }

    }
}