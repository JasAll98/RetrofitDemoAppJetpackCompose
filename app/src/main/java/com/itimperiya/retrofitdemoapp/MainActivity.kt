package com.itimperiya.retrofitdemoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.itimperiya.retrofitdemoapp.ui.QurbaqaApp
import com.itimperiya.retrofitdemoapp.ui.theme.RetrofitDemoAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RetrofitDemoAPPTheme {
                Surface (modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
                    QurbaqaApp()
                }
            }
        }
    }
}
