package com.example.mymastermind.model

import com.example.mymastermind.logic.GameManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
//pont entre la logique du jeu (modèle) et l'interface utilisateur (vue)
class GameViewModel : ViewModel() {
    public val gameManager = GameManager() // Assumes GameManager is already implemented
    val gameState = MutableStateFlow(GameState()) // Holds the current state of the game

    fun processGuess(guess: String) {
        viewModelScope.launch {
            val guessList = parseGuess(guess)
            val isCorrect = gameManager.processGuess(guessList)
            if (isCorrect) {
                // Update gameState to reflect the successful guess
                gameState.value = gameState.value.copy(success = true) // Example property
            } else {
                // Update gameState with feedback for the user
                val feedback = gameManager.provideFeedback(guessList)
                gameState.value = gameState.value.copy(feedback = feedback)
            }
        }
    }

    private fun parseGuess(guess: String): List<Fruit> {
        // Implement parsing logic here, converting the guess String to a List<Fruit>
        return emptyList() // Placeholder return
    }

    fun requestHint() {
        TODO("Not yet implemented")
    }
}
