package kr.pe.ssun.myapplication.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = viewModel(),
    navigate: (String, Any?) -> Unit,
) {
    Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier.Companion.fillMaxSize()
                .padding(innerPadding)
                .background(Color.Companion.Red.copy(alpha = 0.3f))
        ) {
            Text("Detail")
        }
    }
}