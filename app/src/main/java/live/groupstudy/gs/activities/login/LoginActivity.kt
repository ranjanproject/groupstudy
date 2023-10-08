package live.groupstudy.gs.activities.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentComposer

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import live.groupstudy.gs.ui.theme.GroupStudyTheme
import live.groupstudy.gs.ui.theme.ScreenGradient

class LoginActivity : ComponentActivity() {

    companion object {
        const val PHONE_NUMBER = "phoneNumber"
        const val TAG = "LoginActivity"
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

                    Column(Modifier.background(Brush.linearGradient(ScreenGradient))) {
                        LoginNavHost()
                    }

                }

            }
        }
    }

    @Composable
    fun LoginNavHost() {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = LoginScreen.GetNumber.routeName
        ) {

            //creating navigation graph
            composable(route = LoginScreen.GetNumber.routeName) {
                GetPhoneNumberScreen(onButtonClicked = {
                    navigateToRoute(
                        navController,
                        LoginScreen.VerifyOTP.routeName,
                        number = it
                    )
                })
            }

            composable(
                route = LoginScreen.VerifyOTP.routeName,
                arguments = listOf(navArgument(PHONE_NUMBER) { type = NavType.StringType })
            ) {
                val number = it.arguments?.getString(PHONE_NUMBER, "")

                if (!number.isNullOrEmpty()) {
                    val hiddenNumber = number.replaceRange(startIndex = 2, endIndex = 7, "****")
                    LoginOTPScreen(
                        number = hiddenNumber,
                        onBackClicked = { navController.navigateUp() },
                        onContinueClicked = {
                            val otp  = it
                        })

                }
            }

        }

    }


    private fun navigateToRoute(
        navController: NavController,
        route: String,
        number: String = ""
    ) {

        navController.navigate(route.replace("{$PHONE_NUMBER}", number))

    }

    @Composable
    private fun LoginActivityScreen() {
        Column(Modifier.background(Brush.linearGradient(ScreenGradient))) {
            GetPhoneNumberScreen(onButtonClicked = { onContinueButtonClicked(it) })
        }
    }

    @Preview
    @Composable
    private fun LoginActivityScreenPreview() {
        LoginActivityScreen()
    }


    private fun onContinueButtonClicked(number: String) {

        val x = number
//        LoginOTPScreen(number = number)
    }
}

