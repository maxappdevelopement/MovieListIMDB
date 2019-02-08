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
    TextView movieDetails, userNote;
    EditText mEditText;
    Button mSaveButton;
    private static final String TAG = "MovieDetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movieDetails = findViewById(R.id.movieDetailTextView);
        userNote = findViewById(R.id.userNote);

       int rank = getIntent().getExtras().getInt("rank");
       Log.d(TAG, "onCreate: " + rank);

       movie = MainActivity.mMovieViewModel.getAllTitles().getValue().get(rank);

       String movieInformation =
                       "Title: " + movie.getTitle() +
                       "\nDirector: " + movie.getDirector() +
                       "\nActors: " + movie.getActors() +
                       "\nGenre: " + movie.getGenre() +
                       "\nYear: " + movie.getYear() +
                       "\nIMDB Rating: " + movie.getRating();

       movieDetails.setText(movieInformation);

           if (movie.getUserNote()!=null) {
               String displayUserNote = "Note: " + movie.getUserNote();
               userNote.setText(displayUserNote);
           }

//EditText-------------------------------------------------------------------------

        mEditText = findViewById(R.id.editText);
        mSaveButton = findViewById(R.id.saveButton);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = mEditText.getText().toString();
                movie.setUserNote(note);
                userNote.setText("Note: " + note);
                MainActivity.mMovieViewModel.updateUserNote(movie);

            }
        });

//Spinner--------------------------------------------------------------------------

        Spinner spinner = findViewById(R.id.currency_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ratings_array, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

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

