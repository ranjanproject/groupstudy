package live.groupstudy.gs.activities.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
    onBackClicked: () -> Unit = {},
    onContinueClicked: (String) -> Unit = {}
) {

    var otpValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier
            .fillMaxSize()
            .background(Brush.linearGradient(ScreenGradient))
    ) {

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_33)))


        Text(
            text = stringResource(id = R.string.verification_code_title),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_10)))

        Text(
            text = stringResource(id = R.string.we_have_sent_the_code),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_5)))

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = stringResource(id = R.string.to_number, number),
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.dimen_5)))
                Text(text = stringResource(id = R.string.change_phone_number),
                    style = MaterialTheme.typography.bodySmall,
                    color = DarkOrange,
                    modifier = Modifier.clickable { onBackClicked() })
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_60)))

            BasicTextField(
                value = otpValue,
                onValueChange = {
                    if (it.length <= 4) {
                        otpValue = it
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                decorationBox = {
                    OTPBox(otpValue = otpValue)
                })

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_30)))

            GradientButton(
                text = stringResource(id = R.string.continue_btn),
                onButtonClick = { onContinueClicked(otpValue) })


            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_35)))

            Text(text = "30:00")
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_5)))

            Text(
                text = stringResource(id = R.string.resend_code),
                color = DarkOrange,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier.clickable { }
            )
        }

    }
}

@Composable
fun OTPBox(otpValue: String) {

    Row(horizontalArrangement = Arrangement.Center) {
        repeat(4) { index ->
            val char = when {
                index >= otpValue.length -> ""
                else -> otpValue[index].toString()
            }

            Text(
                text = char,
                modifier = Modifier
                    .width(40.dp)
                    .border(1.dp, color = Color.Gray, RoundedCornerShape(10.dp))
                    .padding(10.dp),
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.width(10.dp))
        }

    }
}


@Composable
@Preview(showBackground = true)
fun LoginOTPScreenPreview() {
    LoginOTPScreen("99*****281")
}