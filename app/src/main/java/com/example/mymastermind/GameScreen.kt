package com.example.mymastermind

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.mymastermind.model.Fruit
import com.example.mymastermind.model.GameViewModel

@Composable
fun GameScreen(gameViewModel: GameViewModel = GameViewModel()) {
    val gameState = gameViewModel.gameManager.gameState
    // State for the user's current guess
    val guess = remember { mutableStateOf("") }
    val fruits = Fruit.entries.map { it.displayName }
    val expanded = remember { mutableStateOf(BooleanArray(fruits.size) { false }) }
    val selectedFruits =
        remember { mutableStateOf(List(fruits.size) { Fruit.Fraise }) } // Default selection

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
        Row(verticalAlignment = Alignment.CenterVertically) {
            fruits.indices.take(4).forEach() { index ->
                val fruit = selectedFruits.value[index]
                IconButton(onClick = { expanded.value[index] = true }) {
                    Image(
                        painter = painterResource(id = fruit.imageResId), // Ensure your Fruit enum has an imageResId property
                        contentDescription = fruit.displayName
                    )
                    DropdownMenu(
                        expanded = expanded.value[index],
                        onDismissRequest = { expanded.value[index] = false }
                    ) {
                        DropdownMenuItem(text = {
                            Text("Edit")
                        }, onClick = {
                            selectedFruits.value =
                                selectedFruits.value.toMutableList().apply { this[index] = fruit }
                            expanded.value[index] = false
                        }) {
                            Text(fruit.displayName) // This line is crucial for displaying the fruit names in the dropdown.
                        }
                    }

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

