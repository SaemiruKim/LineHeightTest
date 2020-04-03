package net.meshkorea.android.lineheighttest

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.LineBackgroundSpan
import android.util.Log
import android.util.TypedValue
import android.widget.TextView
import kotlin.math.roundToInt

object SpanUtils {

    fun setTextWithSpan(
        context: Context,
        textView: TextView,
        backgroundColor: Int,
        text: String,
        lineHeight: Float
    ) {
        class BackgroundColorSpanWithPaddingAndLineSpacing(
            private val backgroundColor: Int,
            private val paddingSize: Int,
            private val roundedCornerSize: Float
        ) :
            LineBackgroundSpan {
            private val rect: RectF = RectF()

            override fun drawBackground(
                c: Canvas,
                p: Paint,
                left: Int,
                right: Int,
                top: Int,
                baseline: Int,
                bottom: Int,
                text: CharSequence?,
                start: Int,
                end: Int,
                currentLineNumber: Int
            ) {
                val textWidth = p.measureText(text, start, end).roundToInt()
                val paintColor: Int = p.color
                p.color = backgroundColor
                if (top > 0) {
                    c.drawRoundRect(
                        left.toFloat(),
                        top.toFloat() - textView.lineSpacingExtra,
                        left + textWidth.toFloat(),
                        top + textView.textSize - textView.lineSpacingExtra,
                        roundedCornerSize,
                        roundedCornerSize,
                        p
                    )
                } else {
                    c.drawRoundRect(
                        left.toFloat(),
                        top.toFloat() + context.dp2px(2f),
                        left + textWidth.toFloat(),
                        top.toFloat() + context.dp2px(2f) + textView.textSize,
                        roundedCornerSize,
                        roundedCornerSize,
                        p
                    )
                }
                p.color = paintColor
            }
        }

        val padding = textView.paddingLeft
        val radius = padding / 2
        val builder = SpannableStringBuilder(text)
        val backgroundSpan =
            BackgroundColorSpanWithPaddingAndLineSpacing(backgroundColor, padding, radius.toFloat())

        builder.setSpan(backgroundSpan, 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        // textView.setShadowLayer(padding.toFloat(), 0f, 0f, 0)
        // textView.setLineSpacing(-12f, 1.0f)
        // textView.setl = lineHeight

        Log.i("TAG", "${textView.lineHeight} : {${context.toDp(textView.textSize)}}")
        textView.setText(builder, TextView.BufferType.SPANNABLE)
    }
}

fun Context.dp2px(dpSize: Float): Float =
    TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, dpSize,
        resources.displayMetrics
    )

fun Context.toDp(dp: Float): Int =
    (dp / this.resources.displayMetrics.density).roundToInt()
