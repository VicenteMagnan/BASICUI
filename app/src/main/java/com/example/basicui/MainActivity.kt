package com.example.basicui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.basicui.databinding.ActivityMainBinding
import splitties.alertdialog.*
import splitties.toast.toast
import splitties.activities.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener {
            showAlertDialog()
            //start<SecondaryActivity>()
        }

        binding.internet.setOnClickListener {
            browse("www.chillcoding.com")
        }

        binding.mail.setOnClickListener {
            sendEmail("dylan.andre@ynov.com", "Hi", "Hello !")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAlertDialog() {
        alertDialog {
            messageResource = R.string.text_alert
            okButton { showAlertDialog() }
            cancelButton()
        }.onShow {
            positiveButton.setText(R.string.action_like)
        }.show()
    }

    private fun browse(url: String) {
        var browser = Intent(Intent.ACTION_VIEW, Uri.parse("https://" + url))
        startActivity(browser)
    }

    private fun sendEmail(to: String, subject: String, msg: String) {
        val emailIntent = Intent(Intent.ACTION_SEND)

        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type = "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(to))
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, msg)

        try {
            startActivity(Intent.createChooser(emailIntent, getString(R.string.title_send_email)))
        } catch (ex: ActivityNotFoundException) {
            toast(R.string.text_no_email_client)
        }
    }
}