package kr.pe.ssun.myapplication.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) = Box(modifier = modifier) {
    Text(
        modifier = Modifier.align(Alignment.Center),
        text = "Error Occured",
        color = Color.Red
    )
}