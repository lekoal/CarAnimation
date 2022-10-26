package com.example.caranimation.ui

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import com.example.caranimation.databinding.ActivityMainBinding
import org.koin.android.ext.android.getKoin
import org.koin.core.qualifier.named
import kotlin.math.atan2

private const val SCOPE_ID = "main_activity_scope_id"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val scope by lazy {
        getKoin().getOrCreateScope<MainActivity>(SCOPE_ID)
    }

    private val viewModel: MainActivityViewModel by lazy {
        scope.get(named("main_view_model"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCarOnClick()
    }

    private fun setCarOnClick() {
        binding.car2.setOnClickListener {
            val startX = binding.car2.x
            val startY = binding.car2.y
            viewModel.setAnimation(startX, startY)
            startAnimation()
        }
    }

    private fun startAnimation() {
        val tan = floatArrayOf(0f, 0f)
        val pos = floatArrayOf(0f, 0f)
        val objectAnimator = ObjectAnimator.ofFloat(0f, 1f)
        viewModel.pathMeasure.observe(this) { pathMeasure ->
            objectAnimator.duration = (pathMeasure.length * 2).toLong()
            objectAnimator.interpolator = AccelerateDecelerateInterpolator()
            objectAnimator.addUpdateListener {
                val distance = it.animatedValue as Float
                pathMeasure.getPosTan(distance * pathMeasure.length, pos, tan)
                val carX = pos[0]
                val carY = pos[1]
                binding.car2.x = carX
                binding.car2.y = carY
                val degrees = atan2(tan[1], tan[0]) * 180 / Math.PI
                binding.car2.rotation = degrees.toFloat() - 280
            }
            objectAnimator.doOnEnd {
                if (pathMeasure.nextContour()) {
                    startAnimation()
                }
            }
            objectAnimator.start()
        }
    }
}