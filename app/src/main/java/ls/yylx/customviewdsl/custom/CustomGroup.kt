package ls.yylx.customviewdsl.custom

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

//class CustomGroup : View {


//
//    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    constructor(ctx: Context) : super(ctx) {
//
//    }
//
//    constructor(ctx: Context, attrs: AttributeSet) : super(ctx,attrs ) {
//
//    }
//
//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        val width = getSize(100, widthMeasureSpec)
//        val height = getSize(100, heightMeasureSpec)
//
//
//        setMeasuredDimension(width, height)
//    }
//
//
//    inline fun getSize(defaultSize: Int, measureSpec: Int): Int {
//
//        val mode = MeasureSpec.getMode(measureSpec)
//        val size = MeasureSpec.getSize(measureSpec)
//
//        return when (mode) {
//            MeasureSpec.AT_MOST -> size
//            MeasureSpec.EXACTLY -> size
//            MeasureSpec.UNSPECIFIED -> defaultSize
//            else -> defaultSize
//        }
//
//    }
//
//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//        val paint = Paint()
//        paint.color = Color.GREEN
//        //开始绘制
//        canvas?.drawCircle(centerX, centerY, r, paint);
//        canvas?.drawText("aaa", 0F,0F,)
//
//    }

//}