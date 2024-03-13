package com.rumosoft.gradiator

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlin.math.PI
import kotlin.math.pow

// Initial code from https://gist.github.com/EmmanuelGuther/6075494d1f0599fe76a1e6cd0c6e42e5

private const val TO_RADIANS_FACTOR = PI / 180f
private const val INITIAL_ROTATION = 90f

fun Modifier.gradientBackground(
    vararg colorStops: Pair<Float, Color>,
    angle: Float,
) = this.then(
    Modifier.drawBehind {
        val angleRad = (INITIAL_ROTATION - angle) * TO_RADIANS_FACTOR
        val fractionalX = kotlin.math.cos(angleRad).toFloat()
        val fractionalY = kotlin.math.sin(angleRad).toFloat()

        val radius:Float = kotlin.math.sqrt(
            (size.width.pow(2) + size.height.pow(2)) / 2f)
        val offset = center + Offset(fractionalX * radius, fractionalY * radius)

        val exactOffset = Offset(
            x = kotlin.math.min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - kotlin.math.min(offset.y.coerceAtLeast(0f), size.height)
        )

        drawRect(
            brush = Brush.linearGradient(
                colorStops = colorStops,
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset
            ),
            size = size
        )
    }
)
