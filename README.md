# kema
Kotlin Extension Methods for Android

#### Arguments

Methods for Activity, Fragment and android.support.v4.app.Fragment:
* argument(key: String)
```kotlin
// usage
val arg: TypeOfArgument = argument(KEY_OF_ARGUMENT)
// or
val arg = argument<TypeOfArgument>(KEY_OF_ARGUMENT)
```
* lazyArgument(key: String)
```kotlin
// usage
val arg: TypeArgument by lazyArgument(KEY_OF_ARGUMENT)
// or
val arg by lazyArgument<TypeOfArgument>(KEY_OF_ARGUMENT)
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
