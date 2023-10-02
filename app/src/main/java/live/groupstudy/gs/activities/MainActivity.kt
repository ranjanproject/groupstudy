package live.groupstudy.gs.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import live.groupstudy.gs.activities.splash.SplashActivity
import live.groupstudy.gs.ui.theme.GroupStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startSplashActivity()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun startSplashActivity(){
        SplashActivity.start(this)
        finish()
    }
}