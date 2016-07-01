# kema
Kotlin Extension Methods for Android

**System Services**

All included as properties for Context. The name of the property is the name of the class returned with the first letter lower-cased. Example:
```kotlin
// before
getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
// now
bluetoothManager
```
