package fr.tears.customView

import android.app.Application
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class CustomView : View
{
    private val magicArray = Array<MagicCircle>(7, { i : Int -> MagicCircle(width,height) })

    lateinit var mCircle : MagicCircle
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        mCircle =MagicCircle(width, height)
    }

    private lateinit var mPaint: Paint
    private fun init() {
        mPaint = Paint().apply {
            style = Paint.Style.STROKE
            strokeWidth = 10F
        }

    }
    constructor(context: Context) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for (magicCircle in magicArray)
        {
            with(magicCircle)
            {
                canvas?.drawCircle(cx, cy, rad, mPaint)
                mPaint.color= color
                move()
                color = App.sColors[App.sColors.indices.random()]
            }
        }
        with(mCircle)
        {
            move()
            canvas?.drawCircle(cx, cy, rad, mPaint)
            mPaint.color= color
            color = App.sColors[App.sColors.indices.random()]
        }
        invalidate()

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null)
        {
            magicArray[0].moveTo(event.x,event.y)
        }
        return super.onTouchEvent(event)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {init()}


}

