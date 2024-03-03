package live.groupstudy.gs.activities.mood
import androidx.annotation.DrawableRes
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

data class MoodTileItem(
    @DrawableRes val imageId: Int,
    val title: String,var modifier: Modifier = Modifier.shadow(8.dp))
{
}
