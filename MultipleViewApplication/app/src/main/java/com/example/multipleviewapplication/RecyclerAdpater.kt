package com.example.multipleviewapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.multipleviewapplication.databinding.ImagePostViewBinding
import com.example.multipleviewapplication.databinding.ImageViewBinding
import com.example.multipleviewapplication.databinding.PostViewBinding
import com.squareup.picasso.Picasso
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    private val context : Context,
    private val itemList : MutableList<Any>,
    private val viewTypeList : MutableList<Int>
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class PostViewHolder(private val binding: PostViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(postTextValue : String) {
            binding.postText.text = postTextValue
        }
    }

    class ImageViewHolder(private val binding: ImageViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            imageUrl : String,
            context: Context
        ) {

            Glide.with(context)
                .load(imageUrl)
                .into(binding.imageView)
        }
    }

    class ImagePostViewHolder(private val binding: ImagePostViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            imageUrl : String,
            postTextValue: String,
            context: Context
        ) {

            Glide.with(context)
                .load(imageUrl)
                .into(binding.imageView)

            binding.postText.text = postTextValue
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType) {

            ViewType.Post.viewType -> {
                PostViewHolder(binding = PostViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))
            }

            ViewType.Image.viewType -> {
                ImageViewHolder(binding = ImageViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))
            }

            ViewType.ImagePost.viewType -> {
                ImagePostViewHolder(binding =  ImagePostViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ))
            }

            else -> {
                throw IllegalArgumentException("This View Holder is not available")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(viewTypeList[position]) {

            ViewType.Post.viewType -> {
                (holder as PostViewHolder).bind(postTextValue = (itemList[position] as PostModel).postText)
            }

            ViewType.Image.viewType -> {
                (holder as ImageViewHolder).bind(
                    imageUrl = (itemList[position] as ImageModel).imageUrl,
                    context = context
                )
            }

            ViewType.ImagePost.viewType -> {
                (holder as ImagePostViewHolder).bind(
                    imageUrl = (itemList[position] as ImagePostModel).imageUrl,
                    context = context,
                    postTextValue = (itemList[position] as ImagePostModel).imageText
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun getItemViewType(position: Int): Int {
        return viewTypeList[position]
    }
}