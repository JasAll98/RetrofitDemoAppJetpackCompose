package com.itimperiya.retrofitdemoapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itimperiya.retrofitdemoapp.R
import com.itimperiya.retrofitdemoapp.ui.screens.HomeScreen
import com.itimperiya.retrofitdemoapp.ui.screens.QurbaqaViewModel

@Composable
fun QurbaqaApp() {
    Scaffold (
        topBar = {
            QurbaqaTopBar()
        }
    ) {
        Surface (modifier = Modifier.fillMaxSize()) {
            val qurbaqaViewModel: QurbaqaViewModel = viewModel()
            HomeScreen(qurbaqaUiState = qurbaqaViewModel.qurbaqaUiState, contentPadding = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QurbaqaTopBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name)
            )
        }
    )
}
