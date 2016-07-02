# kema
Kotlin Extension Methods for Android

## dp to pixels conversion (my favourite)
```kotlin
// usage
val eightDpInPixels = 8.dp

// before (the simplest one, I've seen far more complicated)
val eightDpInPixels = (8 * Resources.getSystem().displayMetrics.density + 0.5f).toInt()
```

## Arguments

Methods for `Activity`, `Fragment` and `android.support.v4.app.Fragment`:
* argument(key)
```kotlin
// usage
val arg = argument<ArgumentType>(KEY)

// before
val arg = intent.extras.get(KEY) as ArgumentType // for Activity
val arg = arguments.get(KEY) as ArgumentType // for Fragments
```
* lazyArgument(key)
```kotlin
// usage
val arg by lazyArgument<ArgumentType>(KEY)

// before
val arg: ArgumentType by lazy { intent.extras.get(KEY) as ArgumentType } // for Activity
val arg: ArgumentType by lazy { arguments.get(KEY) as ArgumentType } // for Fragments
```

## Color

Properties for `Context`:
* colorAccent
* colorPrimary
* colorPrimaryDark
 
Property for `String`:
* asColor
```kotlin
// usage
val color = "#442288".asColor
```

## Drawable

Property for `Drawable`
* tint
```kotlin
// usage
mDrawable.tint = mColor

// before
if (Build.VERSION.SDK_INT >= 21) {
    mDrawable.setTint(value)
} else {
    DrawableCompat.setTint(DrawableCompat.wrap(mDrawable), mColor)
}
```

## Menu

Methods for `Menu`:
* forEach { }
* get operator for ids
```kotlin
// usage
val menuItem = menu[id]

// before
val menuItem = menu.findItem(id)
```
* tint(color)
```kotlin
// usage
menu.tint(color)

// before
for (i in 0..menu.size()-1) {
    val icon = menu.getItem(i).icon
    if (Build.VERSION.SDK_INT >= 21) icon.setTint(color)
    else DrawableCompat.setTint(DrawableCompat.wrap(icon), color)
}
```

Methods for `Activity`:
* inflate(menuResId, menu)
```kotlin
// usage
override fun onCreateOptionsMenu(menu: Menu) = inflate(R.menu.main, menu)

// before
override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.main, menu)
    return true
}
```


## System Bars

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

## System Services

They are **all included** as properties for `Context`. The name of the property is the name of the returned class with the first letter lower-cased. Examples:
```kotlin
// usage
val lm = locationManager
val js = jobScheduler

// before
val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
val js = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

```

## Ternary operator

```kotlin
// usage (not so useful, but there it is)
val v = (condition) % true / false

// before 
val v = if (condition) true else false
```

## View

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

## ViewGroup
* Properties
  * children: List<View> 
* Functions
  * inflate(layoutResId): View
```kotlin
// usage
val view = parent.inflate(layoutResId)

// before
val view = LayoutInflater.from(parent.context).inflate(parent, layoutResId, false);
```
