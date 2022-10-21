package com.example.caranimation.utils

import android.graphics.PathMeasure

class PMeasure {
    fun get(startX: Float, startY: Float) : PathMeasure {
        val carPath = CarPath().get(startX, startY)
        return PathMeasure(carPath, false)
    }
}