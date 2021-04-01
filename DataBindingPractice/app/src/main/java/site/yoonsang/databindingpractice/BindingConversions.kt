package site.yoonsang.databindingpractice

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingConversions {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {

        Glide.with(imageView.context)
            .load(url)
            .error(R.drawable.doollee)
            .into(imageView)

        Log.d("checkkk", "img ${imageView.context}")
        Log.d("checkkk", "img ${imageView.id}")
        Log.d("checkkk", "url $url")
    }
}