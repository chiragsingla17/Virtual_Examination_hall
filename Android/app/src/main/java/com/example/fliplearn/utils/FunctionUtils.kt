package com.example.fliplearn.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import java.util.*

class FunctionUtils {
    fun toaster(message: String, context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun appInstalledOrNot(uri: String, context: Context): Boolean {
        val pm: PackageManager = context.packageManager
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            return true
        } catch (ignored: PackageManager.NameNotFoundException) {
        }
        return false
    }

    private fun openWebsiteOnWeb(website: String, context: Context) {
        val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
        webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(webIntent)
    }

    fun getRandomNumber(min: Int, max: Int): Int {
        return (Math.random() * (max - min) + min).toInt()
    }

    fun getTransactionMethod(): List<String> {
        return listOf<String>(
            "Earned from Course Completion",
            "Earned from Maths Calculus Quiz: ",
            "Daily streak",
            "Earned from Course Completion",
            "Earned from doubt solved",
            "Earned from Maths Calculus Quiz: ",
            "Daily streak",
            "Earned from Course Completion",
            "Earned from doubt solved",
            "Daily Streak"
        )
    }

    fun getRandomTime(begin: Calendar, end: Calendar): Calendar? {
        val rnd = Random()
        val min: Long = begin.timeInMillis
        val max: Long = end.timeInMillis
        val randomNum: Long = min + rnd.nextLong() % (max - min + 1)
        val res: Calendar = Calendar.getInstance()
        res.timeInMillis = randomNum
        return res
    }
}