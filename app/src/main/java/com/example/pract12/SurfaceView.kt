package com.example.pract12

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.MotionEvent

class SurfaceView(context: Context?) : GLSurfaceView(context) {

    private var renderer: com.example.pract12.Renderer = Renderer()
    private val TOUCH_SCALE_FACTOR = 180.0f / 320
    private var previousX = 0f
    private var previousY = 0f

    init {
        setEGLContextClientVersion(2)
        setRenderer(renderer)
        //renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        val x = e.x
        val y = e.y
        when (e.action) {
            MotionEvent.ACTION_MOVE -> {
                var dx = x - previousX
                var dy = y - previousY

                if (y > height / 2) {
                    dx = dx * -1
                }

                if (x < width / 2) {
                    dy = dy * -1
                }
                renderer.mAngle = renderer.mAngle + (dx + dy) * TOUCH_SCALE_FACTOR

                requestRender()
            }
        }
        previousX = x
        previousY = y
        return true
    }

}