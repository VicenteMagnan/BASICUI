package com.example.basicui

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent

fun Context.share(text: Int, subject: Int = R.string.app_name):  Boolean {
    try {
        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "text/plain"
        intent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(subject))
        intent.putExtra(android.content.Intent.EXTRA_TEXT, getString(text))
        startActivity(Intent.createChooser(intent, null))
        return true
    } catch (e: ActivityNotFoundException) {
        e.printStackTrace()
        return false
    }
}