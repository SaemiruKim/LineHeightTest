package net.meshkorea.android.lineheighttest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    private fun initListeners() {
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
