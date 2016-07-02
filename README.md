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

#### Color

Properties for `Context`:
.colorAccent
.colorPrimary
.colorPrimaryDark
 
Property for `String`:
.asColor
```kotlin
// usage
val color = "#442288".asColor
```

#### Drawable

Property for `Drawable`
tint
```kotlin
// before
if (Build.VERSION.SDK_INT >= 21) {
    mDrawable.setTint(value)
} else {
    DrawableCompat.setTint(DrawableCompat.wrap(mDrawable), mColor)
}

// now
mDrawable.tint = mColor
```

#### System Bars

Properties for `Context`:
```kotlin
hasNavigationBar // Boolean
isNavigationBarHorizontal // Boolean
navigationBarCanChangeItsPosition // Boolean
statusBarHeight // Int
navigationBarHeight // Int
navigationBarWidth // Int
```
Methods for `View`:
```kotlin
setLightStatusBar()
```

#### System Services

All included as properties for `Context`. The name of the property is the name of the returned class with the first letter lower-cased. Examples:
```kotlin
// before
val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
val js = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

// now
val lm = locationManager
val js = jobScheduler
```

#### Ternary operator

```kotlin
// before 
val v = if (condition) true else false

// now (not so useful... but there it is)
val v = (condition) % true / false
```
|now|before|
|---|---|
|`val v = (condition) % true / false`|`val v = if (condition) true else false`|

#### View

Methods for `View`
* show()
* hide()
* showIf(condition)
* setPaddingStart(paddingStart)
* setPaddingEnd(paddingEnd)
* setPaddingTop(paddingTop)
* setPaddingBottom(paddingBottom)
* setPaddingDp(left, top, right, bottom)
* setMargins(left, top, right, bottom)
* setMarginsDp(left, top, right,)
* elevate(elevation)
* isAttachedToWindow()
* isInBounds(anotherView)
* onClick { }
* onLongClick { }
