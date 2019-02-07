package appdevelopement.max.movielist250;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    private int id;

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private final TextView movieItemViewTitle, movieItemViewScore;


        private MovieViewHolder(View itemView) {
            super(itemView);
            movieItemViewTitle = itemView.findViewById(R.id.itemView_displayTitle);
            movieItemViewScore = itemView.findViewById(R.id.itemView_displayScore);
        }

    }

    private final LayoutInflater mInflater;
    private List<Movie> mMovies;

    MovieListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {

        if (mMovies != null) {
            final Movie current = mMovies.get(position);
            int rank = current.getRank();
            String rankTitle = rank + " " + current.getTitle();
            String imdbRatingUserRating;
            if (current.getUserRating() == 0) {
                imdbRatingUserRating = ("IMDB Rating " + current.getRating() + "\nYour Rating: ");
            } else {
                imdbRatingUserRating = ("IMDB Rating " + current.getRating() + "\nYour Rating: " + current.getUserRating());
            }
            holder.movieItemViewTitle.setText(rankTitle);
            holder.movieItemViewScore.setText(imdbRatingUserRating);

            holder.movieItemViewTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent detailActivity = new Intent(view.getContext(), MovieDetailActivity.class);
                    detailActivity.putExtra("row", position);
                    view.getContext().startActivity(detailActivity);
                }
            });

        } else {
            holder.movieItemViewTitle.setText("No Movie");
        }
    }

    void setMovies(List<Movie> movies){
        mMovies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mMovies != null)
            return mMovies.size();
        else return 0;
    }


}
