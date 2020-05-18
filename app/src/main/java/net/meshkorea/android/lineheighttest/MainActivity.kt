package net.meshkorea.android.lineheighttest

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            WebView.setWebContentsDebuggingEnabled(true)
        } catch (e: PackageManager.NameNotFoundException) {
            // Logger.w(TAG, "Failed to set web contents debugging enabled", e)
        }

        initListeners()
    }

    private fun initListeners() {
        webViewButton.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }

        englishButton.setOnClickListener {
            startActivity(Intent(this, EnglishTestActivity::class.java))
        }

        addOneButton.setOnClickListener {
            startActivity(Intent(this, AddOneActivity::class.java))
        }

        addTwoButton.setOnClickListener {
            startActivity(Intent(this, AddTwoActivity::class.java))
        }

        detailSettingsButton.setOnClickListener {
            val intent = Intent().apply {
                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                data = Uri.Builder().scheme("package").opaquePart(applicationContext.packageName).build()
            }
            startActivity(intent)
        }

        developmentSettings.setOnClickListener {
            val intent = Intent().apply {
                action = Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS
            }
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            val intent = Intent().apply {
                action = Settings.ACTION_APPLICATION_SETTINGS
            }
            startActivity(intent)
        }

        notificationSettingsButton.setOnClickListener {
            val intent = Intent().apply {
                action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
                putExtra(Settings.EXTRA_APP_PACKAGE, applicationContext.packageName)
            }
            startActivity(intent)
        }

        channelNotificationSettingsButton.setOnClickListener {
            val intent = Intent().apply {
                action = Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS
                putExtra(Settings.EXTRA_APP_PACKAGE, applicationContext.packageName)
                putExtra(Settings.EXTRA_CHANNEL_ID, "")
            }
            startActivity(intent)
        }
    }
}
