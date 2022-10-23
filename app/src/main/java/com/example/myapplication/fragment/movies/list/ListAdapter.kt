package com.example.myapplication.fragment.movies.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.agrument.VideoDetailArgument
import com.example.myapplication.common.Variable
import com.example.myapplication.dto.movies.MovieItem
import com.squareup.picasso.Picasso
import kotlin.random.Random

class ListAdapter(private val dataSet: List<MovieItem>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private var itemListener: ((name: VideoDetailArgument) -> Unit)? = null
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.content)
        val poster: ImageView = view.findViewById(R.id.poster)
        val actor: TextView = view.findViewById(R.id.actor)
        val ratingbar: RatingBar = view.findViewById(R.id.ratingbar)
        val ratingValue: TextView = view.findViewById(R.id.ratingValue)
        val wrapView: View = view.findViewById(R.id.item)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_movie_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, index: Int) {
        val item = dataSet[index]
        viewHolder.textView.text = item.name
        viewHolder.actor.text = item.description
        //set rating value
        val rating:String = getValueRating()
        viewHolder.ratingbar.rating = rating.toFloat()
        viewHolder.ratingValue.text = rating
        // get image
        Picasso.get().load(item.poster.imageUrl)
            .fit()
            .centerCrop()
            .noFade()
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.loading_animation)
            .into(viewHolder.poster)
        //set action
        val argument = VideoDetailArgument(item.id!!, rating)
        viewHolder.wrapView.setOnClickListener {
            itemListener?.invoke(argument)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
    fun setItemListener(listener: ((name: VideoDetailArgument) -> Unit)?) {
        itemListener = listener
    }
    private fun getValueRating () :String {
        val randomIndex = Random.nextInt(Variable.RATING_VALUE.size)
        return Variable.RATING_VALUE[randomIndex]
    }
}