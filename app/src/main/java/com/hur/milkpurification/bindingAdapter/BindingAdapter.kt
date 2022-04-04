package com.hur.milkpurification
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Created by Muhammad Dilawar Khan Azeemi on 10/21/2021
 * Email: ingenious.dilawar@gmail.com
 */
object BindingAdapter
{
    @BindingAdapter("setImageUsingGlide")
    @JvmStatic
    fun setImageUsingGlide(imageView: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty())
            Glide.with(imageView.context).load(imageUrl).placeholder(R.drawable.photo)
                .into(imageView)
    }
}