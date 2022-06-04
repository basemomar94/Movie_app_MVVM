package com.tarek.movieappmvvm.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.tarek.movieappmvvm.R
import com.tarek.movieappmvvm.adapters.HomeAdapter
import com.tarek.movieappmvvm.databinding.FragmentHomeBinding
import com.tarek.movieappmvvm.models.Movie
import com.tarek.movieappmvvm.utilities.CONSTANTS
import com.tarek.movieappmvvm.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

class HomeFragment : Fragment(R.layout.fragment_home), HomeAdapter.ClickInterface {
    var binding: FragmentHomeBinding? = null
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelImp()
        observeMoviesList()


    }


    private fun recycleSetup(moviesList: MutableList<Movie>) {
        binding?.rvMovieList?.apply {
            adapter = HomeAdapter(moviesList, requireContext(), this@HomeFragment)
            layoutManager = GridLayoutManager(requireContext(), 3)
            setHasFixedSize(true)
        }

    }

    private fun viewModelImp() {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private fun observeMoviesList() {
        viewModel.getPopularMovies(CONSTANTS.API_KEY, 1)
        viewModel.moviesList.observe(viewLifecycleOwner) {
            recycleSetup(it)
        }
    }

    override fun onClick(movie: Movie, position: Int) {
      //  Log.d("IMG", " ${CONSTANTS.IMG_URL}${movie.poster_path}")
        goToDetails(movie)
    }

    private fun goToDetails(movie: Movie) {
        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        val bundle = Bundle()
        bundle.putSerializable("movie", movie)
        navController.navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }


}