# kema
Kotlin Extension Methods for Android

#### dp to pixels conversion (my favourite)
```kotlin
// before (the simplest one, I've seen far more complicated)
val eightDpInPixels = (8 * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

// now
val eightDpInPixels = 8.dp
```

#### Arguments

Methods for `Activity`, `Fragment` and `android.support.v4.app.Fragment`:
* argument(key)
```kotlin
// before
val arg = intent.extras.get(KEY) as ArgumentType // for Activity
val arg = arguments.get(KEY) as ArgumentType // for Fragments

// now
val arg = argument<ArgumentType>(KEY)
```
* lazyArgument(key)
```kotlin
// before
val arg: ArgumentType by lazy { intent.extras.get(KEY) as ArgumentType } // for Activity
val arg: ArgumentType by lazy { arguments.get(KEY) as ArgumentType } // for Fragments

// now
val arg by lazyArgument<ArgumentType>(KEY)
```

#### Color

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

#### Drawable

Property for `Drawable`
* tint
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

#### Menu

Methods for `Menu`:
* forEach { }
* get operator for ids
```kotlin
// before
val menuItem = menu.findItem(id)

// now
val menuItem = menu[id]
```
* tint(color)
```kotlin
// before
for (i in 0..menu.size()-1) {
    val icon = menu.getItem(i).icon
    if (Build.VERSION.SDK_INT >= 21) icon.setTint(color)
    else DrawableCompat.setTint(DrawableCompat.wrap(icon), color)
}

// now
menu.tint(color)
```


Methods for `Activity`:
* inflate(menuResId, menu)
```kotlin
// before
override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.main, menu)
    return true
}

// now
override fun onCreateOptionsMenu(menu: Menu) = inflate(R.menu.main, menu)
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

#### ViewGroup
* Properties
  * children: List<View>
* Functions
  * inflate(layoutResId)
```kotlin
// before
val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false);

// now
val view = parent.inflate(layoutResId)
```
