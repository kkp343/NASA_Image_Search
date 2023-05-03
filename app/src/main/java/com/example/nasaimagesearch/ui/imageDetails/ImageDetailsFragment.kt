package com.example.nasaimagesearch.ui.imageDetails

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.nasaimagesearch.R
import com.example.nasaimagesearch.databinding.FragmentImageDetailsBinding

class ImageDetailsFragment : Fragment(R.layout.fragment_image_details) {

    private val argument by navArgs<ImageDetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentImageDetailsBinding.bind(view)

        binding.apply {
            val nasaDataItem = argument.nasaDataItem
            val nasaImage = argument.nasaImage
            Glide.with(this@ImageDetailsFragment)
                .load(nasaImage.links.first().href)
                .error(R.drawable.ic_error)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressBar.isVisible = false
                        textViewTitle.isVisible = nasaDataItem.title != null
                        textViewDescription.isVisible = nasaDataItem.description != null
                        textViewDateCreated.isVisible = nasaDataItem.date_created != null
                        return false
                    }
                })
                .into(imageView)

            textViewTitle.text = nasaDataItem.title
            textViewDescription.text = nasaDataItem.description
            textViewDateCreated.text = nasaDataItem.date_created
        }
    }
}