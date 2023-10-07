package live.groupstudy.gs.activities.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import kotlinx.coroutines.delay
import live.groupstudy.gs.activities.login.LoginActivity
import live.groupstudy.gs.ui.theme.GroupStudyTheme
import live.groupstudy.gs.ui.theme.ScreenGradient

class SplashActivity : ComponentActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SplashActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupStudyTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreens()
                }
            }
        }
    }

    @Composable
    private fun SplashScreens() {

        var visibleOnboarding by remember {
            mutableStateOf(false)
        }

        Column(Modifier.background(Brush.linearGradient(ScreenGradient))) {
            if (visibleOnboarding) {
                OnBoardingScreen(onButtonClick = {onGetStartedClicked()})
            } else {
                SplashLayout()
            }
        }


        LaunchedEffect(key1 = "Splash", block = {
            delay(2000)
            visibleOnboarding = true
        })

    }

    private fun onGetStartedClicked(){
      LoginActivity.start(this)
      finish()
    }
}