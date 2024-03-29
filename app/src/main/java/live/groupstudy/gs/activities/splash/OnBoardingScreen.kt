package live.groupstudy.gs.activities.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.groupstudy.gs.R
import live.groupstudy.gs.ui.theme.ButtonGradient
import live.groupstudy.gs.ui.theme.ScreenGradient

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier, onButtonClick: (String) -> Unit = {}) {
    Column(
        modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Screen"
            )

            val modifierText = Modifier.fillMaxWidth()

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = dimensionResource(id = R.dimen.dimen_30)),
                verticalArrangement = Arrangement.Bottom
            ) {

                Text(
                    text = stringResource(R.string.join_your_virtual_study),
                    modifierText,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_10)))
                Text(
                    text = stringResource(id = R.string.study_with_friends),
                    modifierText,
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_10)))

                Text(
                    text = stringResource(id = R.string.help_in_focus),
                    modifierText,
                    textAlign = TextAlign.Justify,
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimen_27)))

                GradientButton(
                    stringResource(R.string.get_started),
                    onButtonClick = { onButtonClick("") })
            }
        }
    }
}

@Composable
fun GradientButton(
    text: String,
    textColor: Color = Color.White,
    gradient: Brush = Brush.horizontalGradient(ButtonGradient),
    onButtonClick: (String) -> Unit = {}
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        onClick = { onButtonClick("") },
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimen_12))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dimen_60))
                .background(gradient), contentAlignment = Alignment.Center
        )
        {
            Text(
                text = text,
                color = textColor,
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.dimen_10),
                        bottom = dimensionResource(id = R.dimen.dimen_10)
                    ),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    OnBoardingScreen(Modifier.background(Brush.linearGradient(ScreenGradient)))
}