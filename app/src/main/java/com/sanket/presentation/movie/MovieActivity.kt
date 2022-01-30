package com.sanket.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.sanket.R
import com.sanket.databinding.ActivityMovieBinding
import com.sanket.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)

        (application as Injector).createMovieSubComponent().inject(this)
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        setupRecycler()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    private fun updateMovies() {
        binding.progressBar.visibility = View.VISIBLE
        val response = viewModel.updateMovie()
        response.observe(this, Observer {
            if (it != null) {
                adapter.updateMovieList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setupRecycler() {
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        val response = viewModel.getMovies()
        response.observe(this, Observer {
            binding.progressBar.visibility = View.GONE
            binding.rvMovie.visibility = View.VISIBLE
            it?.let {
                adapter.updateMovieList(it)
            }
        })
    }
}