package com.github.nitrico.kema

import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.TextView

fun String.fromHtml(htmlHandler: Html.TagHandler? = null) = Html.fromHtml(this, null, htmlHandler)

val String.fromHtml: Spanned
    get() = Html.fromHtml(this)

var TextView.html: String?
    get() = html
    set(value) = setHtmlText(value)

fun TextView.setHtmlText(string: String?, htmlHandler: Html.TagHandler? = null) {
    if (string != null) {
        text = if (htmlHandler != null) Html.fromHtml(string, null, htmlHandler) else string
        visibility = View.VISIBLE
    }
    else visibility = View.GONE
}
