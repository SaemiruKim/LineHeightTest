package net.meshkorea.android.lineheighttest

import android.os.Bundle
import android.text.SpannableString
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = getString(R.string.line_height_test)
        val spanString = SpannableString(text)

        Log.i("TAG", "${resources.displayMetrics.density}")

        // val result =
        //     buildBackgroundColorSpan(spanString, text, "가져올 수 없습니다.", ContextCompat.getColor(this, R.color.textLine2))
        // headlineBold.text = result

        SpanUtils.setTextWithSpan(this, headlineRegular, ContextCompat.getColor(this, R.color.textLine1), text, 22f)
        SpanUtils.setTextWithSpan(this, headlineBold, ContextCompat.getColor(this, R.color.textLine2), text, 22f)
    }
}
