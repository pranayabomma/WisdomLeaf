package com.pranaya.wisdomleaf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.pranaya.wisdomleaf.Utils.Utils
import com.pranaya.wisdomleaf.data.model.ImageData
import com.pranaya.wisdomleaf.databinding.ViewImageDataBinding

class ImageAdapter(private val images : ArrayList<ImageData>)
    : RecyclerView.Adapter<ImageAdapter.ImageDataViewHolder>(){

    private lateinit var dataBinding : ViewImageDataBinding

        class ImageDataViewHolder(val binding : ViewImageDataBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(data : ImageData) {
                binding.imageData = data
                binding.root.setTag(data.author)

                Glide.with(binding.ivImageData.context)
                    .load(data.downloadUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.ivImageData)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageDataViewHolder {
        dataBinding = ViewImageDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ImageDataViewHolder(dataBinding)

    }

    override fun onBindViewHolder(holder: ImageDataViewHolder, position: Int) {
        holder.bind(images.get(position))
    }

    override fun getItemCount(): Int = images.size


    fun addData(datalist :List<ImageData> ) {
        images.addAll(datalist)
    }


}