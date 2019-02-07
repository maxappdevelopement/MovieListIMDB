package appdevelopement.max.movielist250;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {

    Movie movie;
    TextView movieDetails;
    EditText userRatingInput;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movieDetails = findViewById(R.id.movieDetailTextView);


       int row = getIntent().getExtras().getInt("row");

       movie = MainActivity.mMovieViewModel.getAllTitles().getValue().get(row);

       String movieInformation =
                       "Title: " + movie.getTitle() +
                       "\nDirector: " + movie.getDirector() +
                       "\nActors: " + movie.getActors() +
                       "\nYear: " + movie.getYear() +
                       "\nIMDB Rating: " + movie.getRating();

       movieDetails.setText(movieInformation);


        Spinner spinner = (Spinner) findViewById(R.id.currency_spinner);

        // Create an ArrayAdapter using the String array and a spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ratings_array, R.layout.spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        // Apply the adapter to the spinner

        spinner.setAdapter(adapter);
        if (movie.getUserRating() != 0) {
            int spinnerPosition = adapter.getPosition(String.valueOf(movie.getUserRating()));
            spinner.setSelection(spinnerPosition);
        }


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("selected", "onItemSelected: " + parent.getItemAtPosition(position));

                String rating = parent.getItemAtPosition(position).toString();

                int convertedRating = Integer.parseInt(rating);
                movie.setUserRating(convertedRating);

                MainActivity.mMovieViewModel.updateUserScore(movie);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("nothing", "onNothingSelected: ");
            }
        });
    }


    }


