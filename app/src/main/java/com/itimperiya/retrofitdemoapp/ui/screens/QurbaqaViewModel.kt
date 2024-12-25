package com.itimperiya.retrofitdemoapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itimperiya.retrofitdemoapp.network.QurbaqaApi
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface QurbaqaUiState {
    data class Success(val qurbaqa: String) : QurbaqaUiState
    object Loading : QurbaqaUiState
    object Error : QurbaqaUiState
}

class QurbaqaViewModel : ViewModel() {

    var qurbaqaUiState: QurbaqaUiState by mutableStateOf(QurbaqaUiState.Loading)
        private set

    init {
        getQurbaqalar()
    }

    fun getQurbaqalar() {
        viewModelScope.launch {
            QurbaqaUiState.Loading
            qurbaqaUiState = try {
                val listResult = QurbaqaApi.retrofitService.getQurbaqalar()
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

}