# kema
Kotlin Extension Methods for Android

#### System Bars

Properties for Context:
```kotlin
hasNavigationBar
isNavigationBarHorizontal
navigationBarCanChangeItsPosition
statusBarHeight
navigationBarHeight
navigationBarWidth
```
Methods for View:
```kotlin
setLightStatusBar()
```

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
