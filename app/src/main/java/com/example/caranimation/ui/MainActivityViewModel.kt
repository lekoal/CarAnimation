package com.example.caranimation.ui

import android.graphics.PathMeasure
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.caranimation.utils.PMeasure

class MainActivityViewModel : MainContract.ViewModel() {

    private val _pathMeasure = MutableLiveData<PathMeasure>()
    val pathMeasure: LiveData<PathMeasure> = _pathMeasure

    override fun setAnimation(startX: Float, startY: Float) {
        val pMeasure = PMeasure()
        _pathMeasure.value = pMeasure.get(startX, startY)
    }

}