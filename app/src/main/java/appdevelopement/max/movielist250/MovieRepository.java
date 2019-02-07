package appdevelopement.max.movielist250;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class MovieRepository {

    // !! Repository implements the logic for deciding whether to fetch data from a network or use results cached in a local database !!
    // om du ska uppdatera de ny imdb-lista från nätet om användaren är uppkopplad...

    private MovieDao mMovieDao;
    private LiveData<List<Movie>> mAllTitles;

    MovieRepository(Application application) {
        MovieRoomDatabase db = MovieRoomDatabase.getDataBase(application);
        mMovieDao = db.mMovieDao();
        mAllTitles = mMovieDao.getAllTitles();
    }

    public LiveData<List<Movie>> getAllTitles() {
        return mAllTitles;
    }





    void insertRatingForMovie(Movie movie)
    {
        new insertAsyncTask2(mMovieDao).execute(movie);
    }
    private static class insertAsyncTask2 extends AsyncTask<Movie, Void, Void> {

        private MovieDao mAsyncTaskDao;

        insertAsyncTask2(MovieDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Movie... params) {
            mAsyncTaskDao.insertRatingForMovie(params[0].getUserRating(), params[0].getTitle());
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


