package com.github.nitrico.kema

import android.content.res.Resources
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

val Fragment.ctx: FragmentActivity
    get() = activity

val Fragment.act: FragmentActivity
    get() = activity

val Fragment.res: Resources
    get() = resources

val FragmentActivity.fm: FragmentManager
    get() = supportFragmentManager

fun FragmentActivity.setFragment(fragment: Fragment, containerId: Int = android.R.id.content) {
    fm.beginTransaction().add(containerId, fragment).commit()
}
