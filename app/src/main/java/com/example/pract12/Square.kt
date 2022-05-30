package com.example.pract12

import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.nio.ShortBuffer

class Square {

    private var vertexBuffer: FloatBuffer
    private var drawListBuffer: ShortBuffer

    val COORDS_PER_VERTEX = 3
    var squareCoords = floatArrayOf(
        -0.5f, 0.5f, 0.0f,
        -0.5f, -0.5f, 0.0f,
        0.5f, -0.5f, 0.0f,
        0.5f, 0.5f, 0.0f
    )

    private val drawOrder = shortArrayOf(0, 1, 2, 0, 2, 3)

    init {
        val bb = ByteBuffer.allocateDirect(
            squareCoords.size * 4
        )
        bb.order(ByteOrder.nativeOrder())
        vertexBuffer = bb.asFloatBuffer()
        vertexBuffer.put(squareCoords)
        vertexBuffer.position(0)

        val dlb = ByteBuffer.allocateDirect(
            drawOrder.size * 2
        )
        dlb.order(ByteOrder.nativeOrder())
        drawListBuffer = dlb.asShortBuffer()
        drawListBuffer.put(drawOrder)
        drawListBuffer.position(0)
    }

}