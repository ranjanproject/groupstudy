package live.groupstudy.gs.activities.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.groupstudy.gs.R
import live.groupstudy.gs.activities.splash.GradientButton
import live.groupstudy.gs.ui.theme.DarkOrange
import live.groupstudy.gs.ui.theme.ScreenGradient

@Composable
fun LoginOTPScreen(
    number: String,
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit = {}
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Brush.linearGradient(ScreenGradient))
    ) {

        HeadingText(text = stringResource(id = R.string.verification_code_title))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = stringResource(id = R.string.we_have_sent_the_code))
        Spacer(modifier = Modifier.height(5.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(id = R.string.to_number, number))
                Text(text = stringResource(id = R.string.change_phone_number),
                    color = DarkOrange,
                    modifier = Modifier.clickable { onBackClicked() })
            }
            Spacer(modifier = Modifier.height(40.dp))

            EnterOtpView()
            Spacer(modifier = Modifier.height(20.dp))

            GradientButton(text = stringResource(id = R.string.continue_btn))
            Spacer(modifier = Modifier.height(40.dp))

            Text(text = "30:00")
            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = stringResource(id = R.string.resend_code),
                color = DarkOrange,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable {  }
            )
        }

    }
}

@Composable
fun EnterOtpView() {
    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }
    var text3 by remember {
        mutableStateOf("")
    }
    var text4 by remember {
        mutableStateOf("")
    }
    Row {
        OtpText(text = text1, onValueChanged = { text1 = it })
        Spacer(modifier = Modifier.width(15.dp))
        OtpText(text = text2, onValueChanged = { text2 = it })
        Spacer(modifier = Modifier.width(15.dp))
        OtpText(text = text3, onValueChanged = { text3 = it })
        Spacer(modifier = Modifier.width(15.dp))
        OtpText(text = text4, onValueChanged = { text4 = it })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpText(text: String, onValueChanged: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = { onValueChanged(it) },
        Modifier.width(60.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
@Preview(showBackground = true)
fun LoginOTPScreenPreview() {
    LoginOTPScreen("99*****281")
}