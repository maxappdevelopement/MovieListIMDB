package appdevelopement.max.movielist250;

        import android.arch.lifecycle.LiveData;
        import android.arch.persistence.room.Dao;
        import android.arch.persistence.room.Insert;
        import android.arch.persistence.room.OnConflictStrategy;
        import android.arch.persistence.room.Query;
        import android.arch.persistence.room.Update;

        import java.util.List;

@Dao
public interface MovieDao {

    @Query("UPDATE movie_table SET userRating = :user_rating WHERE title = :movie_name")
    int insertRatingForMovie(int user_rating, String movie_name);

    @Query("UPDATE movie_table SET userNote = :user_note WHERE title = :movie_name")
    void insertNoteForMovie(String user_note, String movie_name);

    @Query("SELECT * FROM movie_table WHERE genre LIKE :movie_genre")
    LiveData<List<Movie>> getAllGenre(String movie_genre);

    @Update
    void insertOnlySingleMovie(Movie movie);

    @Insert
    void insertMultipleMovies (List<Movie> movieList);

    @Query("DELETE FROM movie_table")
    void deleteAll();

    @Query("SELECT * FROM movie_table")
    LiveData<List<Movie>> getAllTitles();

    // ORDER BY movieId ASC
}

