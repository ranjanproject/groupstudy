
package live.groupstudy.gs.activities.mood
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import live.groupstudy.gs.R
import javax.security.auth.Subject
class TotalCount {
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
        members: List<TotalMember> = listOf(TotalMember(name = stringResource(R.string.student), subject=stringResource(R.string.subject),300, streak = 300, count = 2000),
            TotalMember(name = stringResource(R.string.student), subject=stringResource(R.string.subject), isLive=500, streak = 500, count = 3000),
            TotalMember(name = stringResource(R.string.student), subject=stringResource(R.string.subject), isLive=600, streak = 600, count = 4000)
        ), modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            Text(text = "Total: ${members.size}", fontSize = 23.sp)
//            Text(text = "Total: ${members.size}", fontSize = dimensionResource(id = R.dimen.dimen_23))
        }
    }
}

