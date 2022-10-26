package com.example.caranimation.utils

import kotlin.random.Random

class RandCoords() {

    fun randomX(width: Float) = Random.nextInt(0, width.toInt()).toFloat()
    fun randomY(height: Float) = Random.nextInt(0, height.toInt()).toFloat()

}