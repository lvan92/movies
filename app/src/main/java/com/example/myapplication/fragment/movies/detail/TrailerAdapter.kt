package com.example.myapplication.fragment.movies.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.dto.trailer.TrailerItem
import com.squareup.picasso.Picasso

class TrailerAdapter(private val data: List<TrailerItem>): RecyclerView.Adapter<TrailerAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val poster: ImageView = view.findViewById(R.id.poster)
        val titleTrailer: TextView = view.findViewById(R.id.image_title)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.image_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        Picasso.get().load(item.image.url)
            .fit()
            .centerCrop()
            .noFade()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.loading_animation)
            .into(holder.poster)
        holder.titleTrailer.text = item.title
    }

    override fun getItemCount(): Int {
        return data.size
    }

}