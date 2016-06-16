package com.github.nitrico.kema

import android.support.v4.view.ViewPager

fun ViewPager.addListener(onSelected: (position: Int) -> Unit = {},
                          onScrolled: (Triple<Int,Float,Int>) -> Unit = {},
                          onScrollStateChanged: (state: Int) -> Unit = {}
) = addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
    override fun onPageSelected(i: Int) = onSelected(i)
    override fun onPageScrolled(i: Int, o: Float, p: Int) = onScrolled(Triple(i, o, p))
    override fun onPageScrollStateChanged(state: Int) = onScrollStateChanged(state)
})
