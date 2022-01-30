package com.sanket.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanket.R
import com.sanket.data.models.movie.Movie
import com.sanket.databinding.ListItemBinding

class MovieAdapter() : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private val movieList = ArrayList<Movie>()
    fun updateMovieList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    class ViewHolder(val listItemBinding: ListItemBinding) :
        RecyclerView.ViewHolder(listItemBinding.root) {
        fun bind(data: Movie) {
            listItemBinding.txtTitle.text = data.title
            listItemBinding.txtDesc.text = data.overview
            val posterUrl = "https://image.tmdb.org/t/p/w500/" + data.posterPath
            Glide.with(listItemBinding.imgCover.context).load(posterUrl)
                .into(listItemBinding.imgCover)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}