package com.example.farmersapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.farmersapp.ApmcPrices.ApmcViewModel
import com.example.farmersapp.App.FarmersApp
import com.example.farmersapp.SplashScreen.MainViewModel
import com.example.farmersapp.ui.theme.FarmersAppTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    val apmcViewModel: ApmcViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }

            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.65f, 0.0f


                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500
                zoomX.doOnEnd { screen.remove() }


                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.65f, 0.0f


                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()

            }
        }

        setContent {
            FarmersAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        FarmersApp(apmcViewModel)
    }

}


