package com.tarek.movieappmvvm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.squareup.picasso.Picasso
import com.tarek.movieappmvvm.databinding.MovieListItemBinding
import com.tarek.movieappmvvm.models.Movie
import com.tarek.movieappmvvm.utilities.CONSTANTS

class HomeAdapter(
    private val moviesList: MutableList<Movie>,
    val context: Context,
    val clickInterface: ClickInterface
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: MovieListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        init {
            binding.cvIvMoviePoster.setOnClickListener {
                val movie = moviesList[absoluteAdapterPosition]
                clickInterface.onClick(movie, absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            MovieListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(moviesList[position]) {
                binding.cvMovieTitle.text = this.title
                binding.cvMovieReleaseDate.text = this.release_date
                val url = CONSTANTS.IMG_URL + this.poster_path
                /*   Picasso.get().load(url)
                       .into(binding.cvIvMoviePoster)*/
                Glide.with(context).load(url).transition(
                    DrawableTransitionOptions.withCrossFade(200)
                ).into(binding.cvIvMoviePoster)

            }
        }

    }

    override fun getItemCount() = moviesList.size

    interface ClickInterface {
        fun onClick(movie: Movie, position: Int)

    }





}