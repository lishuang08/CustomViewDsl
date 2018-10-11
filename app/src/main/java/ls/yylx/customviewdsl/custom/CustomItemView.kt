package ls.yylx.customviewdsl.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import ls.yylx.customviewdsl.R
import org.jetbrains.anko.dip
import org.jetbrains.anko.sp


class CustomItemView : View {
    var textName: String = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    var bitmap: Drawable? = null

    var textNameX = dip(56 + 16)
    var textTagX = 0

    var textWith = 0


    constructor(ctx: Context) : super(ctx) {
        bitmap = resources.getDrawable(R.mipmap.ic_launcher)
    }


    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) {
        bitmap = resources.getDrawable(R.mipmap.ic_launcher)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = getSize(100, widthMeasureSpec)
        val height = getSize(100, heightMeasureSpec)



        textWith = width - dip(56 + 56)
        textTagX = width - dip(56 )



        setMeasuredDimension(width, height)
    }


    inline fun getSize(defaultSize: Int, measureSpec: Int): Int {

        val mode = View.MeasureSpec.getMode(measureSpec)
        val size = View.MeasureSpec.getSize(measureSpec)

        return when (mode) {
            View.MeasureSpec.AT_MOST -> size
            View.MeasureSpec.EXACTLY -> size
            View.MeasureSpec.UNSPECIFIED -> defaultSize
            else -> defaultSize
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.BLACK


        canvas?.apply {
            bitmap?.apply {
                setBounds(0, 0, dip(56), dip(56))
            }?.draw(canvas)
        }

        val tp = TextPaint()
        tp.color = Color.BLACK
        tp.style = Paint.Style.FILL
        tp.textSize = sp(14).toFloat()
//        val mPaint = Paint()
//        mPaint.textSize = sp(14).toFloat()
//        mPaint.color = Color.BLACK
//        val mBound = Rect()
//        mPaint.getTextBounds(textName, 0, textName.length, mBound)
//        mPaint.textAlign = Paint.Align.LEFT
//
//        val x = width / 2 - mPaint.measureText(textName) / 2
//        val fontMetrics = mPaint.fontMetricsInt
//        val baseline = height / 2 - fontMetrics.descent +
//                (fontMetrics.bottom - fontMetrics.top) / 2

        val layout = StaticLayout(textName, tp, textWith, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true)
        // 这里的参数300，表示字符串的长度，当满300时，就会换行，也可以使用“\r\n”来实现换行
        canvas?.save()
        canvas?.translate(textNameX.toFloat(), 0F)//从100，100开始画
        layout.draw(canvas)
        canvas?.restore()//别忘了restore

//        drawText(textName, textNameX.toFloat(), width/2.toFloat(), paint)

//        canvas?.drawText(textName, textNameX.toFloat(), baseline.toFloat(), tp)


        canvas?.drawText("tag", textTagX.toFloat(), sp(12).toFloat(), tp)


//        // 绘制起点、基线
//        mPaint.setColor(Color.YELLOW);
//        mPaint.setStrokeWidth(5);
//        canvas.drawLine(0, baseline, getWidth(), baseline, mPaint);
//        canvas.drawLine(x, 0, x, getHeight(), mPaint);
//
//        // 绘制View的中线,做对比
//        mPaint.setColor(Color.BLACK);
//        mPaint.setStrokeWidth(5);
//        canvas.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2, mPaint);
//        canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight(), mPaint);


    }

}