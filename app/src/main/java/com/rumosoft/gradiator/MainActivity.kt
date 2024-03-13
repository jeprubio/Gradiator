package com.rumosoft.gradiator

import android.graphics.Color.parseColor
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
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
import androidx.compose.ui.viewinterop.AndroidView
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

@Composable
fun SampleTraditionalViewsGradientDrawable() {
    AndroidView(factory = { context ->
        return@AndroidView View(context)
    }) {
        val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                parseColor("#FABADA"),
                parseColor("#F2E377"),
                parseColor("#FFEEAA"),
            )
        )
        gradientDrawable.cornerRadius = 0f

        it.background = gradientDrawable
    }
}


@Preview(showBackground = true)
@Composable
fun SampleGradientPreview() {
    GradiatorTheme {
        SampleGradient()
    }
}


@Preview(widthDp = 200, heightDp = 200, showBackground = true)
@Composable
fun SampleTraditionalViewsPreview() {
    GradiatorTheme {
        SampleTraditionalViewsGradientDrawable()
    }
}
