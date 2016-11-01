package com.github.nitrico.kema

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.BatteryManager
import android.os.Build
import android.os.Environment

val currentSdk = Build.VERSION.SDK_INT
val beforeKitkat = currentSdk < 19
val kitkat = currentSdk == 19
val kitkatOrNewer = currentSdk >= 19
val lollipop = currentSdk == 21
val lollipopOrNewer = currentSdk >= 21
val marshmallow = currentSdk == 23
val marshmallowOrNewer = currentSdk >= 23
val nougat = currentSdk == 24
val nougatOrNewer = currentSdk >= 24

val noSdCard = Environment.MEDIA_MOUNTED != Environment.getExternalStorageState()

fun Context.isAppInstalled(packageName: String): Boolean {
    try {
        return packageManager.getPackageInfo(packageName, 0) != null
    } catch (e: PackageManager.NameNotFoundException) {
        return false
    }
}

fun getBatteryLevel(batteryIntent: Intent): Float {
    val level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
    val scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
    return level / scale.toFloat()
}

fun getBatteryInfo(batteryIntent: Intent): String {
    val status = batteryIntent.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
    val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING
            || status == BatteryManager.BATTERY_STATUS_FULL
    val chargePlug = batteryIntent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
    val usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
    val acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC

    val level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
    val scale = batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)

    val batteryPct = level / scale.toFloat()
    return "Battery Info: isCharging=$isCharging usbCharge=$usbCharge acCharge=$acCharge batteryPct=$batteryPct"
}

inline fun doIf(condition: Boolean?, action: () -> Unit) {
    if (condition == true) action()
}

inline fun doIf(condition: () -> Boolean?, action: () -> Unit) {
    if (condition() == true) action()
}

inline fun doIf(any: Any?, action: () -> Unit) {
    if (any != null) action()
}


// Preconditions

fun <T: Any> throwIfNull(obj: T?, message: String? = "object is null") {
    if (obj == null) throw IllegalArgumentException(message)
}

fun throwIfEmpty(obj: String?, message: String? = "string is null or empty") {
    if (obj == null || obj.length == 0) throw IllegalArgumentException(message)
}

fun <T: Any> throwIfEmpty(obj: Collection<T>?, message: String? = "collection is null or empty") {
    if (obj == null || obj.size == 0) throw IllegalArgumentException(message)
}

fun throwIfFalse(condition: Boolean, message: String? = "condition is false") {
    if (!condition) throw IllegalArgumentException(message)
}

fun throwIfTrue(condition: Boolean, message: String? = "condition is true") {
    if (condition) throw IllegalArgumentException(message)
}
