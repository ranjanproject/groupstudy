package live.groupstudy.gs.activities.login

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun HeadingText(text: String, modifier: Modifier = Modifier){
    Text(text = text, style = MaterialTheme.typography.titleLarge)
}

@Composable
fun SubHeadingText(text: String, modifier: Modifier = Modifier){
    Text(text = text)
}