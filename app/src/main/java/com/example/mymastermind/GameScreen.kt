package com.example.mymastermind

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mymastermind.model.Fruit
import com.example.mymastermind.model.GameViewModel

@Composable
fun GameScreen(navController: NavController, gameViewModel: GameViewModel = GameViewModel()) {
    val gameState = gameViewModel.gameManager.gameState
    // State for the user's current guess
    val guess = remember { mutableStateOf("") }

    Column {
        HistoryScreen()  // Assuming you have a HistoryScreen composable
        // UI for entering and submitting a guess
        Row(verticalAlignment = Alignment.CenterVertically) {
            gameState.selectedFruits.forEach { fruit ->
                IconButton(onClick = { /* do something */ }) {
                    Image(
                        painter = painterResource(id = fruit.imageResId),
                        contentDescription = fruit.displayName
                    )
                }
                }

        }

//__________________________________________________________________________________
            Button(onClick = {
                gameViewModel.processGuess(guess.value)
            }) {
                Text("Guess")
            }

            HintsScreen()
        }
}
    // Display game state and hints here

