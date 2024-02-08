package com.example.mymastermind.model

import com.example.mymastermind.R

enum class Fruit(val hasSeeds: Boolean, val isPeelable: Boolean, val displayName: String, val imageResId: Int) {
    Fraise(hasSeeds = true, isPeelable = false, displayName = "Fraise", R.drawable.strawberry),
    Banane(hasSeeds = false, isPeelable = true, displayName = "Banane", R.drawable.banana),
    Framboise(hasSeeds = false, isPeelable = false, displayName = "Framboise", R.drawable.raspberry),
    Kiwi(hasSeeds = false, isPeelable = true, displayName = "Kiwi", R.drawable.kiwi),
    Orange(hasSeeds = true, isPeelable = true, displayName = "Orange", R.drawable.orange),
    Prune(hasSeeds = true, isPeelable = false, displayName = "Prune", R.drawable.prune),
    Raisin(hasSeeds = true, isPeelable = false, displayName = "Raisin", R.drawable.grape),
    Citron(hasSeeds = true, isPeelable = true, displayName = "Citron", R.drawable.lemon),
}

fun Fruit.info(): String = "$displayName, $imageResId, Seeds: $hasSeeds, Peelable: $isPeelable"
