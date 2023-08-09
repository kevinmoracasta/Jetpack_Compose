package co.edu.sena.myapp2687386
import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.sena.myapp2687386.ui.theme.MyApp2687386Theme
import android.content.res.Configuration
import android.view.textclassifier.ConversationAction
import androidx.annotation.ColorRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp2687386Theme {
                Surface(modifier = Modifier.fillMaxSize(),color=MaterialTheme.colorScheme.scrim) {
                    MessageCard(Message (author = "ken ", body = "supervision "))
                }
        }
        }
    }
}

data class Message(val author: String,val body:String)

@Composable
fun MessageCard(msg: Message) {

    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(painter = painterResource(id = R.drawable.icone-utilisateur), contentDescription = "contact profile picture",modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(1.dp))
        var isExpanded by remember {mutableStateOf(false)}
        Surface(){
        }

        Column (modifier = Modifier.clickable { isExpanded = !isExpanded }){
            Text(
            text = msg.author,
            color = MaterialTheme.colorScheme.inverseOnSurface,style= MaterialTheme.typography.titleSmall
            )
            Surface(shape = MaterialTheme.shapes.large, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyLarge)

            }
        }
    }
}

@Composable
fun Comversation(messages: List<Message>){
    LazyColumn {
        items(messages){message ->
            MessageCard(message)

        }
    }
}
@Preview
@Composable
fun ConversationPreview(){
    MyApp2687386Theme{
    Surface(color=MaterialTheme.colorScheme.scrim) {
        Comversation(SampleData.conversationSample)

    }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {
    MyApp2687386Theme {
        Surface {
            MessageCard(Message("kevin","Es la vida  "))
        }
    }
}
