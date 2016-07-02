# kema
Kotlin Extension Methods for Android

#### Arguments

Methods for `Activity`, `Fragment` and `android.support.v4.app.Fragment`:
* argument(key)
```kotlin
// usage
val arg: ArgumentType = argument(KEY_OF_ARGUMENT)
// or
val arg = argument<ArgumentType>(KEY_OF_ARGUMENT)
```
* lazyArgument(key)
```kotlin
// usage
val arg: ArgumentType by lazyArgument(KEY_OF_ARGUMENT)
// or
val arg by lazyArgument<ArgumentType>(KEY_OF_ARGUMENT)
```

#### System Bars

Properties for Context:
```kotlin
hasNavigationBar // Boolean
isNavigationBarHorizontal // Boolean
navigationBarCanChangeItsPosition // Boolean
statusBarHeight // Int
navigationBarHeight // Int
navigationBarWidth // Int
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
