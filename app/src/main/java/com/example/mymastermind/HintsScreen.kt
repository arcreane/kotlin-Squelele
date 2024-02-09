package com.example.mymastermind

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.mymastermind.model.GameViewModel
//Montre les indices.
@Composable
fun HintsScreen(gameViewModel: GameViewModel = GameViewModel()) {
    val gameState = gameViewModel.gameState.collectAsState().value

    Column() {
        Text("Hints", style = MaterialTheme.typography.labelSmall)
        // Assuming you have a method in your GameViewModel to request a hint
        Button(onClick = { gameViewModel.processGuess(gameState.feedback) }) {
            Text("Get a Hint")
        }
        // Display the current hint
        Text("Hint: ${gameState.feedback}") // Assuming currentHint is a String in your GameState
        //gameState.addGuess()
    }
}
