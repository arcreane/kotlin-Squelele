package com.example.mymastermind

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mymastermind.model.GameViewModel
import androidx.compose.ui.Modifier

@Composable
fun HintsScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameState = gameViewModel.gameState.collectAsState().value

    Column() {
        Text("Hints", style = MaterialTheme.typography.labelSmall)
        // Assuming you have a method in your GameViewModel to request a hint
        Button(onClick = { gameViewModel.requestHint() }) {
            Text("Get a Hint")
        }
        // Display the current hint
        Text("Hint: ${gameState.feedback}") // Assuming currentHint is a String in your GameState
    }
}
