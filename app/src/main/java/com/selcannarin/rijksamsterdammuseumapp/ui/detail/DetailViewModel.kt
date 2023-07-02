package com.selcannarin.rijksamsterdammuseumapp.ui.detail

import android.app.Application
import com.selcannarin.rijksamsterdammuseumapp.data.model.viewstate.MuseumDetailViewState
import com.selcannarin.rijksamsterdammuseumapp.data.remote.NetworkResult
import com.selcannarin.rijksamsterdammuseumapp.data.repository.MuseumDetailRepository
import com.selcannarin.rijksamsterdammuseumapp.ui.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val museumDetailRepository: MuseumDetailRepository,
    application: Application
) : BaseViewModel(application) {
    private val _artObjectDetailState = MutableStateFlow(MuseumDetailViewState())
    val artObjectDetailState: StateFlow<MuseumDetailViewState> = _artObjectDetailState.asStateFlow()

    suspend fun getArtObjectDetail(objectNumber: String) {
        museumDetailRepository.fetchArtObjectDetail(objectNumber).collect { result ->
            when (result) {
                is NetworkResult.Success -> {
                    _artObjectDetailState.value =
                        result.data?.let {
                            MuseumDetailViewState(
                                artObjectDetail = it,
                                isLoading = false
                            )
                        }!!
                }
                is NetworkResult.Error -> {
                    _artObjectDetailState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message ?: "An unexpected error occurred"
                        )
                    }
                }
                is NetworkResult.Loading -> {
                    _artObjectDetailState.update {
                        it.copy(isLoading = true)
                    }
                }
            }
        }
    }
}