package com.itimperiya.retrofitdemoapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.itimperiya.retrofitdemoapp.R
import com.itimperiya.retrofitdemoapp.network.Qurbaqa

@Composable
fun HomeScreen(
    qurbaqaUiState: QurbaqaUiState,
    contentPadding: PaddingValues,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (qurbaqaUiState) {
        is QurbaqaUiState.Success -> ResultScreen(
            qurbaqaUiState.qurbaqa,
            modifier.padding(contentPadding)
        )

        is QurbaqaUiState.Error -> ErrorScreen(
            retryAction = retryAction,
            modifier.padding(contentPadding)
        )

        is QurbaqaUiState.Loading -> LoadingScreen(modifier.padding(contentPadding))
    }

}

@Composable
fun QurbaqaCard(qurbaqa: Qurbaqa, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Row (modifier = Modifier.padding(8.dp)) {
                Text(text = qurbaqa.name, style = MaterialTheme.typography.displayLarge)
                Text(text = " (${qurbaqa.type})", style = MaterialTheme.typography.displayLarge)
            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(qurbaqa.imgSrc)
                    .build(),
                contentDescription = stringResource(R.string.qurbaqa_photo),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = qurbaqa.description, modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.bodyLarge)
        }
    }

}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.no_connection),
                contentDescription = stringResource(R.string.no_connection),
                tint = LocalContentColor.current,
                modifier = Modifier.width(120.dp)
            )
            Button(onClick = retryAction) {
                Text(text = stringResource(R.string.retry))
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.width(120.dp),
            strokeWidth = 20.dp,
            strokeCap = StrokeCap.Round,
            color = ProgressIndicatorDefaults.circularColor
        )
    }
}

@Composable
fun ResultScreen(qurbaqalar: List<Qurbaqa>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(qurbaqalar) {
            QurbaqaCard(it, Modifier.padding(4.dp))
        }
    }
}