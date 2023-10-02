package live.groupstudy.gs.activities.ui

import android.widget.EditText
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.groupstudy.gs.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetPhoneNumberScreen(modifier: Modifier = Modifier){

    Column(
        modifier
            .fillMaxSize()
            .padding(20.dp)) {
        val textModifier = Modifier.fillMaxWidth()
        var number by remember {
            mutableStateOf("")
        }
        Text(text = stringResource(id = R.string.sign_in_or_create_an_account), textModifier)
        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = number,
            onValueChange = {newNum ->if(newNum.length<=10){number = newNum}},
            modifier = textModifier,
            placeholder = { Text(text = stringResource(id = R.string.phone_no))},
            leadingIcon = {Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "",  Modifier.size(30.dp))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(40.dp))
        GradientButton(text = stringResource(id = R.string.continue_btn))
    }
}

@Preview(showBackground = true)
@Composable
fun GetPhoneNumberScreenPreview(){
    GetPhoneNumberScreen()
}