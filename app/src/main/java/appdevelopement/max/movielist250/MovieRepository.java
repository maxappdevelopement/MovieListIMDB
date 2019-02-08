package appdevelopement.max.movielist250;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import java.util.List;

public class MovieRepository {

    // Repository implements the logic for deciding whether to fetch data from a network or use results cached in a local database
    // om du ska uppdatera de ny imdb-lista från nätet om användaren är uppkopplad...

    private MovieDao mMovieDao;
    private LiveData<List<Movie>> mAllTitles;
    private LiveData<List<Movie>> mAllGenres;

    MovieRepository(Application application) {
        MovieRoomDatabase db = MovieRoomDatabase.getDataBase(application);
        mMovieDao = db.mMovieDao();
        mAllTitles = mMovieDao.getAllTitles();
    }

    public LiveData<List<Movie>> getAllTitles() {
        return mAllTitles;
    }

    public LiveData<List<Movie>> getAllGenres(String genre) {
        mAllGenres = mMovieDao.getAllGenre(genre);
        return mAllGenres;
    }

    void insertRatingForMovie(Movie movie)
    {
        new insertAsyncTaskUserRating(mMovieDao).execute(movie);
    }
    private static class insertAsyncTaskUserRating extends AsyncTask<Movie, Void, Void> {

        private MovieDao mAsyncTaskDao;

        insertAsyncTaskUserRating(MovieDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... params) {
            mAsyncTaskDao.insertRatingForMovie(params[0].getUserRating(), params[0].getTitle());
            return null;
        }
    }


    void insertNoteForMovie(Movie movie)
    {
        new insertAsyncTaskUserNote(mMovieDao).execute(movie);
    }
    private static class insertAsyncTaskUserNote extends AsyncTask<Movie, Void, Void> {

        private MovieDao mAsyncTaskDao;

        insertAsyncTaskUserNote(MovieDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... params) {
            mAsyncTaskDao.insertNoteForMovie(params[0].getUserNote(), params[0].getTitle());
            return null;
        }
    }


    void insert(Movie movie) {
        new insertAsyncTask(mMovieDao).execute(movie);
    }

    private static class insertAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDao mAsyncTaskDao;

        insertAsyncTask(MovieDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... params) {
            mAsyncTaskDao.insertOnlySingleMovie(params[0]);
            return null;
        }
    }

}


