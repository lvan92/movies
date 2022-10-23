package com.example.myapplication.fragment.movies.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dto.image.ImageRelated
import com.squareup.picasso.Picasso

class ImageAdapter(private val data: List<ImageRelated>): RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var poster: ImageView = view.findViewById(R.id.poster)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.image_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        Picasso.get().load(item.url)
            .fit()
            .centerCrop()
            .noFade()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.loading_animation)
            .into(holder.poster)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}