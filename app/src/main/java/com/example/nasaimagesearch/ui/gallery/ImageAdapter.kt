package com.example.nasaimagesearch.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.nasaimagesearch.R
import com.example.nasaimagesearch.data.NasaImage
import com.example.nasaimagesearch.databinding.ItemImageBinding

class ImageAdapter(private val listener: OnItemClickListener) : PagingDataAdapter<NasaImage, ImageAdapter.ImageViewHolder>(PHOTO_COMPARATOR) {

    // onCreateViewHolder is used inflate ItemLayout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return ImageViewHolder(binding)
    }

    // Decides which data should be bind to respective ItemLayout cell
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(photo: NasaImage) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.urls.href)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                textViewImageName.text = photo.user.imageName
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(photo: NasaImage)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<NasaImage>() {
            override fun areItemsTheSame(oldItem: NasaImage, newItem: NasaImage) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: NasaImage, newItem: NasaImage) =
                oldItem == newItem

        }
    }
}