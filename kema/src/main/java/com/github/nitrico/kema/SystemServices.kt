package com.github.nitrico.kema

import android.accounts.AccountManager
import android.app.*
import android.app.admin.DevicePolicyManager
import android.app.job.JobScheduler
import android.app.usage.NetworkStatsManager
import android.app.usage.UsageStatsManager
import android.appwidget.AppWidgetManager
import android.bluetooth.BluetoothManager
import android.content.ClipboardManager
import android.content.Context
import android.content.RestrictionsManager
import android.content.pm.LauncherApps
import android.hardware.ConsumerIrManager
import android.hardware.SensorManager
import android.hardware.camera2.CameraManager
import android.hardware.display.DisplayManager
import android.hardware.fingerprint.FingerprintManager
import android.hardware.input.InputManager
import android.hardware.usb.UsbManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.media.midi.MidiManager
import android.media.projection.MediaProjectionManager
import android.media.session.MediaSessionManager
import android.media.tv.TvInputManager
import android.net.ConnectivityManager
import android.net.nsd.NsdManager
import android.net.wifi.WifiManager
import android.net.wifi.p2p.WifiP2pManager
import android.nfc.NfcManager
import android.os.*
import android.os.health.SystemHealthManager
import android.os.storage.StorageManager
import android.print.PrintManager
import android.service.wallpaper.WallpaperService
import android.support.v4.app.NotificationManagerCompat
import android.telecom.TelecomManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.accessibility.AccessibilityManager
import android.view.accessibility.CaptioningManager
import android.view.inputmethod.InputMethodManager
import android.view.textservice.TextServicesManager

val Context.accessibilityManager: AccessibilityManager
    get() = getSystemServiceAs(Context.ACCESSIBILITY_SERVICE)

val Context.accountManager: AccountManager
    get() = getSystemServiceAs(Context.ACCOUNT_SERVICE)

val Context.activityManager: ActivityManager
    get() = getSystemServiceAs(Context.ACTIVITY_SERVICE)

val Context.alarmManager: AlarmManager
    get() = getSystemServiceAs(Context.ALARM_SERVICE)

val Context.appWidgetManager: AppWidgetManager
    get() = getSystemServiceAs(Context.APPWIDGET_SERVICE)

val Context.appOpsManager: AppOpsManager
    get() = getSystemServiceAs(Context.APP_OPS_SERVICE)

val Context.audioManager: AudioManager
    get() = getSystemServiceAs(Context.AUDIO_SERVICE)

val Context.batteryManager: BatteryManager
    get() = getSystemServiceAs(Context.BATTERY_SERVICE)

val Context.bluetoothManager: BluetoothManager
    get() = getSystemServiceAs(Context.BLUETOOTH_SERVICE)

val Context.cameraManager: CameraManager
    get() = getSystemServiceAs(Context.CAMERA_SERVICE)

val Context.captioningManager: CaptioningManager
    get() = getSystemServiceAs(Context.CAPTIONING_SERVICE)

val Context.carrierConfigManager: CarrierConfigManager
    get() = getSystemServiceAs(Context.CARRIER_CONFIG_SERVICE)

val Context.clipboardManager: ClipboardManager
    get() = getSystemServiceAs(Context.CLIPBOARD_SERVICE)

val Context.connectivityManager: ConnectivityManager
    get() = getSystemServiceAs(Context.CONNECTIVITY_SERVICE)

val Context.consumerIrManager: ConsumerIrManager
    get() = getSystemServiceAs(Context.CONSUMER_IR_SERVICE)

val Context.devicePolicyManager: DevicePolicyManager
    get() = getSystemServiceAs(Context.DEVICE_POLICY_SERVICE)

val Context.displayManager: DisplayManager
    get() = getSystemServiceAs(Context.DISPLAY_SERVICE)

val Context.downloadManager: DownloadManager
    get() = getSystemServiceAs(Context.DOWNLOAD_SERVICE)

val Context.dropBoxManager: DropBoxManager
    get() = getSystemServiceAs(Context.DROPBOX_SERVICE)

val Context.fingerprintManager: FingerprintManager
    get() = getSystemServiceAs(Context.FINGERPRINT_SERVICE)

val Context.hardwarePropertiesManager: HardwarePropertiesManager
    get() = getSystemServiceAs(Context.HARDWARE_PROPERTIES_SERVICE)

val Context.inputMethodManager: InputMethodManager
    get() = getSystemServiceAs(Context.INPUT_METHOD_SERVICE)

val Context.inputManager: InputManager
    get() = getSystemServiceAs(Context.INPUT_SERVICE)

val Context.jobScheduler: JobScheduler
    get() = getSystemServiceAs(Context.JOB_SCHEDULER_SERVICE)

val Context.keyguardManager: KeyguardManager
    get() = getSystemServiceAs(Context.KEYGUARD_SERVICE)

val Context.launcherApps: LauncherApps
    get() = getSystemServiceAs(Context.LAUNCHER_APPS_SERVICE)

val Context.layoutInflater: LayoutInflater
    get() = getSystemServiceAs(Context.LAYOUT_INFLATER_SERVICE)

val Context.locationManager: LocationManager
    get() = getSystemServiceAs(Context.LOCATION_SERVICE)

val Context.mediaProjectionManager: MediaProjectionManager
    get() = getSystemServiceAs(Context.MEDIA_PROJECTION_SERVICE)

val Context.mediaRouter: MediaRouter
    get() = getSystemServiceAs(Context.MEDIA_ROUTER_SERVICE)

val Context.mediaSessionManager: MediaSessionManager
    get() = getSystemServiceAs(Context.MEDIA_SESSION_SERVICE)

val Context.midiManager: MidiManager
    get() = getSystemServiceAs(Context.MIDI_SERVICE)

val Context.networkStatsManager: NetworkStatsManager
    get() = getSystemServiceAs(Context.NETWORK_STATS_SERVICE)

val Context.nfcManager: NfcManager
    get() = getSystemServiceAs(Context.NFC_SERVICE)

val Context.notificationManager: NotificationManager
    get() = getSystemServiceAs(Context.NOTIFICATION_SERVICE)

val Context.nsdManager: NsdManager
    get() = getSystemServiceAs(Context.NSD_SERVICE)

val Context.powerManager: PowerManager
    get() = getSystemServiceAs(Context.POWER_SERVICE)

val Context.printManager: PrintManager
    get() = getSystemServiceAs(Context.PRINT_SERVICE)

val Context.restrictionsManager: RestrictionsManager
    get() = getSystemServiceAs(Context.RESTRICTIONS_SERVICE)

val Context.searchManager: SearchManager
    get() = getSystemServiceAs(Context.SEARCH_SERVICE)

val Context.sensorManager: SensorManager
    get() = getSystemServiceAs(Context.SENSOR_SERVICE)

val Context.storageManager: StorageManager
    get() = getSystemServiceAs(Context.STORAGE_SERVICE)

val Context.systemHealthManager: SystemHealthManager
    get() = getSystemServiceAs(Context.SYSTEM_HEALTH_SERVICE)

val Context.telecomManager: TelecomManager
    get() = getSystemServiceAs(Context.TELECOM_SERVICE)

val Context.telephonyManager: TelephonyManager
    get() = getSystemServiceAs(Context.TELEPHONY_SERVICE)

val Context.subscriptionService: SubscriptionManager
    get() = getSystemServiceAs(Context.TELEPHONY_SUBSCRIPTION_SERVICE)

val Context.textServicesManager: TextServicesManager
    get() = getSystemServiceAs(Context.TEXT_SERVICES_MANAGER_SERVICE)

val Context.tvInputManager: TvInputManager
    get() = getSystemServiceAs(Context.TV_INPUT_SERVICE)

val Context.uiModeManager: UiModeManager
    get() = getSystemServiceAs(Context.UI_MODE_SERVICE)

val Context.usageStatsManager: UsageStatsManager
    get() = getSystemServiceAs(Context.USAGE_STATS_SERVICE)

val Context.usbManager: UsbManager
    get() = getSystemServiceAs(Context.USB_SERVICE)

val Context.userManager: UserManager
    get() = getSystemServiceAs(Context.USER_SERVICE)

val Context.vibrator: Vibrator
    get() = getSystemServiceAs(Context.VIBRATOR_SERVICE)

val Context.wallpaperService: WallpaperService
    get() = getSystemServiceAs(Context.WALLPAPER_SERVICE)

val Context.wifiP2pManager: WifiP2pManager
    get() = getSystemServiceAs(Context.WIFI_P2P_SERVICE)

val Context.wifiManager: WifiManager
    get() = getSystemServiceAs(Context.WIFI_SERVICE)

val Context.windowManager: WindowManager
    get() = getSystemServiceAs(Context.WINDOW_SERVICE)

val Context.notificationManagerCompat: NotificationManagerCompat
    get() = NotificationManagerCompat.from(this)

@Suppress("UNCHECKED_CAST")
fun <T> Context.getSystemServiceAs(serviceName: String) = getSystemService(serviceName) as T
