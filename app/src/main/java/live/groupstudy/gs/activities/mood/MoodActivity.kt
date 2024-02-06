package live.groupstudy.gs.activities.mood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.groupstudy.gs.R
import live.groupstudy.gs.ui.theme.GroupStudyTheme

class MoodActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    MoodItem()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GroupStudyTheme {
//        Greeting("Android")

    }
    MoodItem()
}

@Composable
fun MoodItem(modifier: Modifier = Modifier) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .height(dimensionResource(id = R.dimen.dimen_120))
            .width(dimensionResource(id = R.dimen.dimen_150))
            .background(
                color = Color.White
            )
            .clip(
                shape = RoundedCornerShape(
                    dimensionResource(id = R.dimen.dimen_10)
                )
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Color.Red else Color.Gray,
                shape = RoundedCornerShape(
                    dimensionResource(id = R.dimen.dimen_10)
                )
            )
            .clickable {
                isSelected = !isSelected
            }

    ) {
        Row {

            Column {

                Image(
                    painter = painterResource(id = R.drawable.silentbuddha),
                    contentDescription = "It is an image of Buddha.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.dimen_85))
                )
                Column(
                    Modifier
                        .padding(dimensionResource(id = R.dimen.dimen_10))
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Silent Buddha",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Column {

                Image(
                    painter = painterResource(id = R.drawable.passionatelover),
                    contentDescription = "It is an image of Bow and Arrow",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.dimen_85))
                )
                Column(
                    Modifier
                        .padding(dimensionResource(id = R.dimen.dimen_10))
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Passionate Lover",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
        Row {
            Column {

                Image(
                    painter = painterResource(id = R.drawable.studypanda),
                    contentDescription = "It is an image of Panda.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.dimen_85))
                )
                Column(
                    Modifier
                        .padding(dimensionResource(id = R.dimen.dimen_10))
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Study Panda",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Column {

                Image(
                    painter = painterResource(id = R.drawable.chanakya),
                    contentDescription = "It is an image of arrow hitting the target.",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.dimen_85))
                )
                Column(
                    Modifier
                        .padding(dimensionResource(id = R.dimen.dimen_10))
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Chanakya",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
        Column {

            Image(
                painter = painterResource(id = R.drawable.ghost),
                contentDescription = "It is an image of Ghost.",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.dimen_85))
            )
            Column(
                Modifier
                    .padding(dimensionResource(id = R.dimen.dimen_10))
                    .fillMaxSize()
            ) {
                Text(
                    text = "Ghost",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
