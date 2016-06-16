package com.github.nitrico.kema

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.net.ConnectivityManager
import android.support.v4.app.NotificationManagerCompat
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.WindowManager

val Context.isPortrait: Boolean get() = resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
val Context.isLandscape: Boolean get() = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
val Context.li: LayoutInflater get() = LayoutInflater.from(this)
val Context.conf: Configuration get() = resources.configuration
val Context.dm: DisplayMetrics get() = resources.displayMetrics
val Context.wm: WindowManager get() = getSystemService(Context.WINDOW_SERVICE) as WindowManager
val Context.nm: NotificationManagerCompat get() = NotificationManagerCompat.from(this)
val Context.res: Resources get() = resources

val Context.isNetworkAvailable: Boolean
    get() {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = cm.activeNetworkInfo
        return network != null && network.isConnected
    }

fun Context.share(text: String, caption: String = text) {
    val intent = Intent(Intent.ACTION_SEND).setType("text/plain").putExtra(Intent.EXTRA_TEXT, text)
    startActivity(Intent.createChooser(intent, caption))
}
