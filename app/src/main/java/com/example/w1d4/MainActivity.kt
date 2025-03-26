package com.example.w1d4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text // for adding Text
import androidx.compose.runtime.Composable // for Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview // for preview the functions in android studio
import androidx.compose.foundation.layout.Column // for using columns
import androidx.compose.foundation.layout.Row // for using rows
import androidx.compose.foundation.Image // for adding images
import androidx.compose.material3.Button // for adding buttons
import androidx.compose.ui.res.painterResource
import com.example.w1d4.ui.theme.W1D4Theme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            W1D4Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }

            ProfileCard(Card("Ethar Alrehaili", "Full-Stack Android Developer"))

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
    W1D4Theme {
        Greeting("Android")
    }
}

// Add multiple texts
data class Card(val name: String, val bio: String)

@Composable
fun ProfileCard(msg: Card) {
    var isFollowing by remember { mutableStateOf(false) }
    var followerCount by remember { mutableStateOf(0) }
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier.fillMaxSize(),
    )
    {
        Row(
            modifier = Modifier
                .padding(all = 8.dp)
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(R.drawable.picture),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp)) // space between the image and the name+bio

            Column {
                Text(text = msg.name)
                Spacer(modifier = Modifier.height(8.dp)) // space between the name and the bio
                Text(text = msg.bio)
                Spacer(modifier = Modifier.height(6.dp)) // space between the bio and the button

                Button(
                    onClick = {
                        if (!isFollowing) {
                            followerCount += 1
                        } else {
                            followerCount -= 1
                        }
                        isFollowing = !isFollowing
                    },
                    interactionSource = interactionSource
                ) {
                    Text(text = if (isFollowing) "Following" else "Follow")
                }
                // Display follower count
                Text("Followers: $followerCount")
            }
        }
    }
}

@Preview
@Composable
fun PreviewProfileCard() {
    ProfileCard(
        msg = Card("Ethar Alrehaili", "Full-Stack Android Developer")
    )
}





















