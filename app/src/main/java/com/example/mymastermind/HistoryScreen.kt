package com.example.mymastermind

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mymastermind.model.GameViewModel

@Composable
fun HistoryScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameState = gameViewModel.gameState.collectAsState().value

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Guess History", style = MaterialTheme.typography.labelLarge)
        LazyColumn {
            items(gameState.guesses) { guess ->
                Text("Guess: ${guess.joinToString(", ")}") // Display each fruit in the guess
                // Optionally, display feedback for each guess if you have such information in your game state
            }
        }
    }
}
