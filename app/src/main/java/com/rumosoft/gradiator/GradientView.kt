package com.rumosoft.gradiator

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

private const val INITIAL_ROTATION = 90f

class GradientView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    val colors: IntArray = intArrayOf(),
    val stops: FloatArray? = null,
    val angleDegrees: Float = 0f,
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    private val matrix = Matrix()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (colors.isEmpty()) return

        val shader = LinearGradient(
            0f,
            0f,
            width.toFloat(),
            0f,
            colors,
            stops,
            Shader.TileMode.CLAMP
        )

        matrix.setRotate(angleDegrees - INITIAL_ROTATION, width / 2f, height / 2f)
        shader.setLocalMatrix(matrix)

        paint.shader = shader

        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}