package com.example.caranimation.utils

import android.graphics.Path

class CarPath {
    private val endX = 0f
    private val endY = 0f

    fun get(startX: Float, startY: Float): Path {
        val coords = RandCoords()
        return Path().apply {
            moveTo(startX, startY)
            quadTo(startX, startY, coords.randomX(startX), coords.randomY(startY))
            lineTo(coords.randomX(startX), coords.randomY(startY))
            quadTo(
                coords.randomX(startX),
                coords.randomY(startY),
                coords.randomX(startX),
                coords.randomY(startY)
            )
            lineTo(coords.randomX(startX), coords.randomY(startY))
            quadTo(
                coords.randomX(startX),
                coords.randomY(startY),
                coords.randomX(startX),
                coords.randomY(startY)
            )
            quadTo(coords.randomX(startX), coords.randomY(startY), endX, endY)
            close()
        }
    }
}