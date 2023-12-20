package com.example.gallery

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector

interface AllGesture : ScaleGestureDetector.OnScaleGestureListener,
    GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {
    /** OnScaleGestureListener ********************************************************************/
    override fun onScale(detector: ScaleGestureDetector): Boolean = false

    override fun onScaleBegin(detector: ScaleGestureDetector): Boolean = true

    override fun onScaleEnd(detector: ScaleGestureDetector) {
    }

    /** OnGestureListener *************************************************************************/
    override fun onDown(e: MotionEvent): Boolean = false

    override fun onShowPress(e: MotionEvent) {
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean = false

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean = false

    override fun onLongPress(e: MotionEvent) {
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean = false

    /** OnDoubleTapListener ***********************************************************************/
    override fun onSingleTapConfirmed(e: MotionEvent): Boolean = false

    override fun onDoubleTap(e: MotionEvent): Boolean = false

    override fun onDoubleTapEvent(e: MotionEvent): Boolean = false
}