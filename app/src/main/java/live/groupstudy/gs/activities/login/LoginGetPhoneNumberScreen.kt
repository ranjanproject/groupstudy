package live.groupstudy.gs.activities.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.groupstudy.gs.R
import live.groupstudy.gs.activities.splash.GradientButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetPhoneNumberScreen(modifier: Modifier = Modifier, onButtonClicked: (String) -> Unit = {}) {
    var number by remember {
        mutableStateOf("")
    }

    Column(
        modifier
            .fillMaxSize()
    ) {
        val textModifier = Modifier.fillMaxWidth()
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_33)))

        Text(
            text = stringResource(id = R.string.sign_in_or_create_an_account),
            textModifier,
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_33)))

        TextField(
            value = number,
            onValueChange = { newNum ->
                if (newNum.length <= 10) {
                    number = newNum
                }
            },
            modifier = textModifier,
            placeholder = { Text(text = stringResource(id = R.string.phone_no), style = MaterialTheme.typography.labelSmall) },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "", Modifier.size(dimensionResource(id = R.dimen.dimen_30))
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_30)))
        GradientButton(
            text = stringResource(id = R.string.continue_btn),
            onButtonClick = { if (number.length == 10) onButtonClicked(number) })
    }
}

@Preview(showBackground = true)
@Composable
fun GetPhoneNumberScreenPreview() {
    GetPhoneNumberScreen()
}