package appdevelopement.max.movielist250;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

@Entity(tableName = "movie_table")
public class Movie {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @Nullable
    @ColumnInfo(name = "rank")
    private int rank;

    @Nullable
    @ColumnInfo(name = "director")
    private String director;

    @Nullable
    @ColumnInfo(name = "actors")
    private String actors;

    @Nullable
    @ColumnInfo(name = "genre")
    private String genre;

    @Nullable
    @ColumnInfo(name = "year")
    private String year;

    @Nullable
    @ColumnInfo(name = "rating")
    private double rating;

    @Nullable
    @ColumnInfo(name = "userRating")
    private int userRating;

    @Nullable
    @ColumnInfo(name = "userNote")
    private String userNote;

    public Movie() { }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    @Nullable
    public int getRank() {
        return rank;
    }

    public void setRank(@Nullable int rank) {
        this.rank = rank;
    }

    @Nullable
    public String getDirector() {
        return director;
    }

    public void setDirector(@Nullable String director) {
        this.director = director;
    }

    @Nullable
    public String getActors() {
        return actors;
    }

    public void setActors(@Nullable String actors) {
        this.actors = actors;
    }

    @Nullable
    public String getGenre() {
        return genre;
    }

    public void setGenre(@Nullable String genre) {
        this.genre = genre;
    }

    @Nullable
    public String getYear() {
        return year;
    }

    public void setYear(@Nullable String year) {
        this.year = year;
    }

    @Nullable
    public double getRating() {
        return rating;
    }

    public void setRating(@Nullable double rating) {
        this.rating = rating;
    }

    @Nullable
    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(@Nullable int userRating) {
        this.userRating = userRating;
    }

    @Nullable
    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(@Nullable String userNote) {
        this.userNote = userNote;
    }
}