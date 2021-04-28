package site.yoonsang.moviemvvm.ui.single_movie_details

import androidx.lifecycle.LiveData
import io.reactivex.disposables.CompositeDisposable
import site.yoonsang.moviemvvm.data.api.TheMovieDBInterface
import site.yoonsang.moviemvvm.data.repository.MovieDetailsNetworkDatasource
import site.yoonsang.moviemvvm.data.repository.NetworkState
import site.yoonsang.moviemvvm.data.vo.MovieDetails

class MovieDetailsRepository(private val apiService: TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDatasource: MovieDetailsNetworkDatasource

    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId: Int): LiveData<MovieDetails> {

        movieDetailsNetworkDatasource = MovieDetailsNetworkDatasource(apiService, compositeDisposable)
        movieDetailsNetworkDatasource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDatasource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDatasource.networkState
    }
}