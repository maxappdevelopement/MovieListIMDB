package appdevelopement.max.movielist250;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MovieRepository mMovieRepository;

    private LiveData<List<Movie>> mAllTitles;
    private LiveData<List<Movie>> mAllGenres;

    public MovieViewModel (Application application) {
        super(application);
        mMovieRepository = new MovieRepository(application);
        mAllTitles = mMovieRepository.getAllTitles();
    }

     public LiveData<List<Movie>> getAllTitles() {
        return mAllTitles;
    }

     public LiveData<List<Movie>> getAllGenres(String genre) {
        mAllGenres = mMovieRepository.getAllGenres(genre);
        return mAllGenres;
     }

     public void insert(Movie movie) {
        mMovieRepository.insert(movie);
  }

     public void updateUserScore(Movie movie) { mMovieRepository.insertRatingForMovie(movie);}

     public void updateUserNote(Movie movie) { mMovieRepository.insertNoteForMovie(movie);}


}
