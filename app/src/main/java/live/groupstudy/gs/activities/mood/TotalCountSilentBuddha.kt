package live.groupstudy.gs.activities.mood
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.sp
import javax.security.auth.Subject
class TotalCountSilentBuddha {
    @Immutable
    data class TotalMember(
        val name: String,
        val subject: String,
        val isLive: Int,
        val count: Int,
        val streak: Int
    ){
        fun displayName(): String{
            return "$name - $subject"
        }
    }
@Preview(showBackground = true)
@Composable
fun DisplayHeader(
    members: List<TotalMember> = listOf(TotalMember("Name 1", "Subject 1", isLive=300, streak = 300, count = 2000),
        TotalMember("Name 2", "Subject 2", isLive=500, streak = 500, count = 3000),
        TotalMember("Name 3", "Subject 3", isLive=600, streak = 600, count = 4000)
    ), modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = "Total: ${members.size}", fontSize = 23.sp)
    }
}
    class TotalMemberProvider : PreviewParameterProvider<List<TotalMember>> {
        override val values: Sequence<List<TotalMember>> = sequence {
            yield(listOf(
                TotalMember("Name 1", "Subject 1", isLive=300, streak = 300, count = 2000),
                TotalMember("Name 2", "Subject 2", isLive=500, streak = 500, count = 3000),
                TotalMember("Name 3", "Subject 3", isLive=600, streak = 600, count = 4000)
            ))
        }
    }
    }

