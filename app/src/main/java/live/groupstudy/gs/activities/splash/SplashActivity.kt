package live.groupstudy.gs.activities.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import live.groupstudy.gs.activities.ui.SplashLayout
import live.groupstudy.gs.ui.theme.GroupStudyTheme

class SplashActivity : ComponentActivity() {

    companion object{
        fun start(context: Context){
            context.startActivity(Intent(context,SplashActivity::class.java))
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
                )   {
                    SplashLayout()
                }
            }
        }
    }
}