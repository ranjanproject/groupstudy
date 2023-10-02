package live.groupstudy.gs.activities.login

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import live.groupstudy.gs.activities.ui.GetPhoneNumberScreen
import live.groupstudy.gs.ui.theme.GroupStudyTheme
import live.groupstudy.gs.ui.theme.ScreenGradient

class LoginActivity : ComponentActivity() {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Brush.linearGradient(ScreenGradient)),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginActivityScreen()
                }
            }
        }
    }
}

@Composable
fun LoginActivityScreen() {
    Column(Modifier.background(Brush.linearGradient(ScreenGradient))) {
        GetPhoneNumberScreen()
    }
}

@Preview
@Composable
fun LoginActivityScreenPreview() {
    LoginActivityScreen()
}