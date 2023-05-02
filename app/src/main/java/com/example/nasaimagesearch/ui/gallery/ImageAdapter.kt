package com.example.nasaimagesearch.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.nasaimagesearch.R
import com.example.nasaimagesearch.api.NasaDataItem
import com.example.nasaimagesearch.api.NasaDataObject
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

        if (currentItem != null && currentItem.data[position] != null) {
            holder.bind(currentItem, currentItem.data[position])
        }
    }

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val nasaDataItem = getItem(position)
                    if (nasaDataItem != null) {
                        listener.onItemClick(
                            nasaDataItem, nasaDataItem.data[position]
                        )
                    }
                }
            }
        }

        fun bind(photo: NasaImage, nasaDataItem: NasaDataItem) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.href)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                textViewImageName.text = nasaDataItem.title
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(nasaImage: NasaImage, nasaDataItem: NasaDataItem)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<NasaImage>() {
            override fun areItemsTheSame(oldItem: NasaImage, newItem: NasaImage) =
                oldItem.data.first().nasa_id == newItem.data.first().nasa_id

            override fun areContentsTheSame(oldItem: NasaImage, newItem: NasaImage) =
                oldItem == newItem

        }
    }
}