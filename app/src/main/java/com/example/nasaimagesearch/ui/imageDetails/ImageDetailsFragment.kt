package com.example.nasaimagesearch.ui.imageDetails

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
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
            val photo = argument.photo
            Glide.with(this@ImageDetailsFragment)
                .load(photo.urls.href)
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
                        textViewTitle.isVisible = photo.title != null
                        textViewDescription.isVisible = photo.description != null
                        textViewDateCreated.isVisible = photo.date != null
                        return false
                    }
                })
                .into(imageView)

            textViewTitle.apply {
                text = photo.title
                val intentTitle = Intent(Intent.ACTION_VIEW)
                context?.startActivity(intentTitle)
            }

            textViewDescription.apply {
                text = photo.description
                val uri = Uri.parse(photo.user.attributionUrl)
                val intentDescription = Intent(Intent.ACTION_VIEW, uri)
                context?.startActivity(intentDescription)
            }

            textViewDateCreated.apply {
                text = photo.date
                val intentDateCreated = Intent(Intent.ACTION_VIEW)
                context?.startActivity(intentDateCreated)
            }


        }
    }
}