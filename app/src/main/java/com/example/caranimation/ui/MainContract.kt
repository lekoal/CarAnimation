package com.example.caranimation.ui

import androidx.appcompat.app.AppCompatActivity

interface MainContract {

    abstract class View : AppCompatActivity() {
    }

    abstract class ViewModel : androidx.lifecycle.ViewModel() {
        abstract fun setAnimation()
    }
}