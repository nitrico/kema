# kema
Kotlin Extension Methods for Android

#### System Services

All included as properties for Context. The name of the property is the name of the returned class with the first letter lower-cased. Examples:
```kotlin
// before
getSystemService(Context.LOCATION_SERVICE) as LocationManager
getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

// now
locationManager
jobScheduler
```
