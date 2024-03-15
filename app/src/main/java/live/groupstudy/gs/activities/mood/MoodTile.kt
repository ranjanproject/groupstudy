package live.groupstudy.gs.activities.mood

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.groupstudy.gs.R

@Composable
fun GenderLogoAndText(
    @DrawableRes resourceId: Int,
    gender: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = "logo",
            modifier = Modifier.size(50.dp)
        )
        Text(
            text = gender,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GenderLogoAndTextPreview() {
    Column {
        GenderLogoAndText(
            resourceId = R.drawable.female,
            gender = stringResource(id = R.string.female),
            onClick = {}
        )
        GenderLogoAndText(
            resourceId = R.drawable.male,
            gender = stringResource(id = R.string.male),
            onClick = {}
        )
    }
}
