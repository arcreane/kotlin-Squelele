package com.example.mymastermind.model
//Suit l'état actuel du jeu.
data class GameState(
    var selectedFruits: List<Fruit> = emptyList(),
    val guesses: MutableList<List<Fruit>> = mutableListOf(),
    var score: Int = 0 ,
    var attemptsLeft: Int = 10,
    var success: Boolean = false,
    var feedback: String = ""
) {

    fun addGuess(guess: List<Fruit>) {
        guesses.add(guess)
        attemptsLeft--
        // Logic to update score based on guess accuracy
    }

    fun restartGame() {
        // Logic to restart the game by resetting the state
        guesses.clear()
        score = 0
        attemptsLeft = 10
        success = false
        feedback = ""
    }

}