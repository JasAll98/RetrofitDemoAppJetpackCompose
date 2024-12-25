package com.itimperiya.retrofitdemoapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itimperiya.retrofitdemoapp.R

@Composable
fun HomeScreen(
    qurbaqaUiState: QurbaqaUiState,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    when (qurbaqaUiState) {
        is QurbaqaUiState.Success -> ResultScreen(qurbaqaUiState.qurbaqa, modifier.padding(contentPadding))
        is QurbaqaUiState.Error -> ErrorScreen(modifier.padding(contentPadding))
        is QurbaqaUiState.Loading -> LoadingScreen(modifier.padding(contentPadding))
    }

}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Icon(
            painter = painterResource(R.drawable.no_connection),
            contentDescription = "No connection"
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.width(120.dp),
            strokeCap = StrokeCap.Round,
        )
    }
}

@Composable
fun ResultScreen(qurbaqa: String, modifier: Modifier = Modifier) {
    Box (
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(
            text = qurbaqa
        )
    }
}