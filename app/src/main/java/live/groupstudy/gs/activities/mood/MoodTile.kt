package live.groupstudy.gs.activities.mood

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import live.groupstudy.gs.R
import live.groupstudy.gs.model.MoodTile
import live.groupstudy.gs.model.MoodTileItem
import live.groupstudy.gs.ui.theme.ScreenGradient


@Composable
fun MoodTile(moodTileItem: MoodTileItem,modifier: Modifier = Modifier) {
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

        Image(
            painter = painterResource(id = moodTileItem.imageId),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dimen_85))



        )
        Column(
            Modifier
                .padding(dimensionResource(id = R.dimen.dimen_10))
                .fillMaxSize()
        )
        {
            Text(
                text = moodTileItem.title,
                style = MaterialTheme.typography.bodySmall
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MoodTilePreview() {
    val moodItemList = listOf(
        MoodTileItem(R.drawable.silentbuddha,  "Silent Buddha"),
        MoodTileItem(R.drawable.passionatelover,  "Passionate Lover"),
        MoodTileItem(R.drawable.studypanda,  "Study Panda"),
        MoodTileItem(R.drawable.chanakya,  "Chanakya"),
        MoodTileItem(R.drawable.ghost,  "Ghost")
    )
    LazyVerticalGrid(columns= GridCells. Fixed(2),
    contentPadding = PaddingValues(40.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)

    ) {
        items(moodItemList) { it->
            MoodTile(it)

        }

    }
}
