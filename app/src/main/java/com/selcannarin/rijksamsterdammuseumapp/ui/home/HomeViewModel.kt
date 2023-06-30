package com.selcannarin.rijksamsterdammuseumapp.ui.home

import android.app.Application
import com.selcannarin.rijksamsterdammuseumapp.data.model.MuseumViewState
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import com.selcannarin.rijksamsterdammuseumapp.data.repository.MuseumRepository
import com.selcannarin.rijksamsterdammuseumapp.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val museumRepository: MuseumRepository,
    application: Application
) : BaseViewModel(application) {
    private val _artObjectState = MutableStateFlow(MuseumViewState())
    val artObjectState: StateFlow<MuseumViewState> = _artObjectState.asStateFlow()

    suspend fun getArtObject() {
        museumRepository.fetchArtObject().collect { result ->
            when (result) {
                is NetworkResult.Success -> {
                    _artObjectState.value =
                        result.data?.let {
                            MuseumViewState(
                                artObjectList = it,
                                isLoading = false
                            )
                        }!!
                }
                is NetworkResult.Error -> {
                    _artObjectState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                }
                is NetworkResult.Loading -> {
                    _artObjectState.update {
                        it.copy(isLoading = true)
                    }
                }
            }
        }
    }
}