package com.tarek.movieappmvvm.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.tarek.movieappmvvm.R
import com.tarek.movieappmvvm.databinding.FragmentDetailsMovieBinding
import com.tarek.movieappmvvm.models.Movie
import com.tarek.movieappmvvm.models.MovieDetails
import com.tarek.movieappmvvm.utilities.CONSTANTS
import com.tarek.movieappmvvm.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


class DetailsFragment : Fragment(R.layout.fragment_details_movie) {
    var binding: FragmentDetailsMovieBinding? = null
    var movie: Movie? = null
    var viewModel: HomeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsMovieBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelImp()

       getMovie()

    }


    private fun getMovie() {
        val args = this.arguments
        if (args != null) {
            movie = args.get("movie") as Movie?
            println(movie)
            movie?.id?.let { getMovieDetails(it) }
        }
    }

    private fun getMovieDetails(id: Int) {
        viewModel?.getMovieDetails(id, CONSTANTS.API_KEY)
        viewModel?.movieDetails?.observe(viewLifecycleOwner) {
            updateUi(it)
            Log.d("Movie", it.overview)
        }

    }

    private fun viewModelImp() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }


    private fun updateUi(movie: MovieDetails) {
        binding?.apply {
            movieTitle.text = movie.title
            movieReleaseDate.text = movie.release_date
            movieRating.text = movie.popularity.toString()
            movieOverview.text = movie.overview


        }
        val url = CONSTANTS.IMG_URL + movie.poster_path
        Glide.with(requireContext()).load(url).into(binding!!.ivMoviePoster)
    }
}