package com.itimperiya.retrofitdemoapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.itimperiya.retrofitdemoapp.QurbaqaApplication
import com.itimperiya.retrofitdemoapp.data.QurbaqaRepository
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface QurbaqaUiState {
    data class Success(val qurbaqa: String) : QurbaqaUiState
    object Loading : QurbaqaUiState
    object Error : QurbaqaUiState
}

class QurbaqaViewModel(private val qurbaqaRepository: QurbaqaRepository) : ViewModel() {

    var qurbaqaUiState: QurbaqaUiState by mutableStateOf(QurbaqaUiState.Loading)
        private set

    init {
        getQurbaqalar()
    }

    fun getQurbaqalar() {
        viewModelScope.launch {
            QurbaqaUiState.Loading
            qurbaqaUiState = try {
                val listResult = qurbaqaRepository.getQurbaqalar()
                QurbaqaUiState.Success(
                    "Success: ${listResult.size} ma'lumotlar soni"
                )
            } catch (e: IOException) {
                QurbaqaUiState.Error
            } catch (e: HttpException) {
                QurbaqaUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as QurbaqaApplication)
                val qurbaqaRepository = application.container.qurbaqaRepository
                QurbaqaViewModel(qurbaqaRepository = qurbaqaRepository)
            }
        }
    }

}