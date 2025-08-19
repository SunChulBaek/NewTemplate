package kr.pe.ssun.myapplication.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import kr.pe.ssun.myapplication.model.Pokemon

@Composable
fun HomeListItem(
    pokemon: Pokemon,
    onClick: () -> Unit
) = Row(
    modifier = Modifier.fillMaxWidth()
        .height(80.dp)
        .border(width = 1.dp, color = Color.Gray)
        .clickable(onClick = onClick)
) {
    SubcomposeAsyncImage(
        modifier = Modifier.fillMaxHeight().aspectRatio(1f),
        model = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemon.id}.png",
        loading = {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        },
        contentDescription = pokemon.name
    )
    Column {
        Text("#${pokemon.id}")
        Text(pokemon.name)
    }
}