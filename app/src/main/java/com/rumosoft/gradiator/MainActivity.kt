package com.rumosoft.gradiator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumosoft.gradiator.ui.theme.GradiatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GradiatorTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    SampleGradient()
                }
            }
        }
    }
}

@Composable
fun SampleGradient() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .gradientBackground(
                0f to Color(0xFFFABADA),
                0.3f to Color(0xFFF2E377),
                1.0f to Color(0xFFFFEEAA),
                angle = 180f
            )
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GradiatorTheme {
        SampleGradient()
    }
}
