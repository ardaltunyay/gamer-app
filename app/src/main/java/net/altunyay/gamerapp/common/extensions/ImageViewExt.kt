package net.altunyay.gamerapp.common.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(url: String) {
    Glide.with(this.context).load(url).into(this)
}

fun ImageView.setImage(url: String, placeholder: Int) {
    Glide.with(this.context).load(url).placeholder(placeholder).into(this)
}