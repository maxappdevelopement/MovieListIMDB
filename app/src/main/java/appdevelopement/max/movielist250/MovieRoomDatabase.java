package appdevelopement.max.movielist250;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {Movie.class}, version = 1)
public abstract class MovieRoomDatabase extends RoomDatabase {
    // TODO: 2019-02-01 understand migrations with room =  https://medium.com/androiddevelopers/understanding-migrations-with-room-f01e04b07929
    public abstract MovieDao mMovieDao();

    private static volatile MovieRoomDatabase INSTANCE;

    static MovieRoomDatabase getDataBase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MovieRoomDatabase.class, "movie_database").
                            addCallback(sRoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final MovieDao mDao;

        PopulateDbAsync(MovieRoomDatabase db) {
            mDao = db.mMovieDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();

            MovieListCreater movieListCreater = new MovieListCreater();
            List<String> titles = movieListCreater.createTitles();
            List<Movie> movieList = new ArrayList<>();

            for (int i = 0; i < 100 ; i++) {
                Movie movie = new Movie();
                movie.setRank(i);
                movie.setTitle(titles.get(i));
                movieList.add(movie);
            }
            mDao.insertMultipleMovies(movieList);

            return null;
        }
    }

}

