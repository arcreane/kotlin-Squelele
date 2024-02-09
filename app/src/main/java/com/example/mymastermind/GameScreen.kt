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

//l'interface principale du jeu
@Composable
fun GameScreen(gameViewModel: GameViewModel = GameViewModel()) {
    val gameState = gameViewModel.gameManager.gameState
    // State for the user's current guess
    val guess = remember { mutableStateOf("") }
    val fruits = Fruit.entries.map { it.displayName }
    val expanded = remember { mutableStateOf(false) }
    val selectedFruits =
        remember { mutableStateOf(Fruit.entries.toTypedArray()) } // Default selection

    Column {
        HistoryScreen()  // l'appel et l'affichage de l'historique (pas terminé)
        // Affichage des 4 fruits 1er row -> les fruits à trouver(pour faciliter les test) second row -> les fruits clickable pour le choix du joueur
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
                IconButton(onClick = { expanded.value = true }) {
                    Image(
                        painter = painterResource(id = fruit.imageResId),
                        contentDescription = fruit.displayName
                    )
                    DropdownMenu(
                        expanded = expanded.value,
                        onDismissRequest = { expanded.value = false }
                    ) {
                        DropdownMenuItem(text = {
                            Text(fruit.displayName)
                        }, onClick = {
                            selectedFruits.value =
                                selectedFruits.value.toMutableList().apply { this[index] = fruit }
                                    .toTypedArray()
                            expanded.value = false
                        })
                    }

                }
            }
        }

        //Bouton qui sert à la comparaison des 4 fruits avec ceux choisit aléatoirement

        Button(onClick = {
            gameViewModel.processGuess(guess.value)
        }) {
            Text("Guess")
        }

        HintsScreen()// indice (pas terminé)

    }

}


// Display game state and hints here

