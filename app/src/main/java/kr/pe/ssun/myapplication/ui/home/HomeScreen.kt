package kr.pe.ssun.myapplication.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.pe.ssun.myapplication.navigation.detailNavigationRoute

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    navigate: (String, Any?) -> Unit,
) {
    Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier.Companion.fillMaxSize()
                .padding(innerPadding)
                .background(Color.Companion.Green.copy(alpha = 0.3f))
        ) {
            Button(
                modifier = Modifier.align(Alignment.Center),
                onClick = { navigate(detailNavigationRoute, null) }
            ) {
                Text("Move To Detail")
            }
        }
    }
}