package com.itimperiya.retrofitdemoapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itimperiya.retrofitdemoapp.R
import com.itimperiya.retrofitdemoapp.ui.screens.HomeScreen
import com.itimperiya.retrofitdemoapp.ui.screens.QurbaqaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QurbaqaApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            QurbaqaTopBar(scrollBehavior)
        }
    ) {
        Surface (modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
            val qurbaqaViewModel: QurbaqaViewModel = viewModel(factory = QurbaqaViewModel.Factory)
            HomeScreen(qurbaqaUiState = qurbaqaViewModel.qurbaqaUiState, retryAction = qurbaqaViewModel::getQurbaqalar, contentPadding = it)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QurbaqaTopBar(scrollBehavior: TopAppBarScrollBehavior) {
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayLarge
            )
        }
    )
}
