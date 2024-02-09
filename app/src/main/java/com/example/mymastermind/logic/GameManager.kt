package com.example.mymastermind.logic

import com.example.mymastermind.model.Fruit
import com.example.mymastermind.model.GameState

class GameManager {
    val gameState = GameState()
    private val allFruits = Fruit.entries

    init {
        generateFruitCombination()
    }

    private fun generateFruitCombination() {
        gameState.selectedFruits = allFruits.shuffled().take(4)
    }

    fun processGuess(guessList: List<Fruit>): Boolean {
        val correctAnswer = gameState.selectedFruits // Assuming this is the correct sequence of fruits
        var correctCount = 0

        guessList.forEachIndexed { index, fruit ->
            if (correctAnswer[index] == fruit) {
                correctCount++
            }
        }

        // Update the game state here, for example, attempts left or setting feedback based on the guess
        gameState.attemptsLeft -= 1 // Assuming you have an attempts left field
        //gameState.lastGuessCorrectCount = correctCount // Assuming you track the number of correct fruits in the last guess

        // Return true if the guess is completely correct, false otherwise
        return correctCount == correctAnswer.size
    }

    fun restartGame() {
        gameState.restartGame()
        generateFruitCombination()
    }
    fun provideFeedback(guessList: List<Fruit>): String {//provideHint
        var correctInPosition = 0
        var correctButWrongPosition = 0
        // Assuming selectedFruits is the correct combination
        val correctCombination = gameState.selectedFruits

        guessList.forEachIndexed { index, fruit ->
            if (correctCombination.contains(fruit)) {
                if (correctCombination[index] == fruit) {
                    correctInPosition++
                } else {
                    correctButWrongPosition++
                }
            }
        }

        return "Correct in position: $correctInPosition, Correct but in wrong position: $correctButWrongPosition"
    }

}
