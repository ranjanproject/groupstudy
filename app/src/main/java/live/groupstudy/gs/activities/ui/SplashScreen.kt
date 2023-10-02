package live.groupstudy.gs.activities.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import live.groupstudy.gs.R
import live.groupstudy.gs.ui.theme.GroupStudyTheme
import live.groupstudy.gs.ui.theme.ScreenGradient


@Composable
fun SplashLayout(modifier: Modifier = Modifier) {

    Column(
        modifier
            .background(Brush.linearGradient(ScreenGradient))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "")
        Text(text = "Group", style = MaterialTheme.typography.titleLarge)
        Text(text = "Study")
    }
}

@Preview(showBackground = true)
@Composable
fun SplashLayoutPreview() {
    GroupStudyTheme {
        SplashLayout()
    }
}