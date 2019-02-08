package appdevelopement.max.movielist250;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonHandler.OnJsonCompleted {

    private JsonHandler mJsonHandler;
    private MovieListAdapter mAdapter;
    public static MovieViewModel mMovieViewModel;
    private MenuItem mMenuItem;
    private int genreId;
    private static final String TAG = "TheMainActivity";

    @Override
    public void taskMovieCompleted(Movie results) {
      mMovieViewModel.insert(results);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mJsonHandler = new JsonHandler(this, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        mAdapter = new MovieListAdapter(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMovieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        setUpFiltering();


    //Fill Database With MovieData -----------------------------------------------------

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LiveData<List<Movie>> getTitles = mMovieViewModel.getAllTitles();

                for (int i = 0; i < getTitles.getValue().size(); i++) {
                    String movie = getTitles.getValue().get(i).getTitle();
                    int rank = getTitles.getValue().get(i).getRank();
                    mJsonHandler.executeLoopjCall(movie, rank);
                }

            }
        });
    }

    //TOOLBAR SETUP---------------------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mMenuItem = item;
        setUpFiltering();
        return super.onOptionsItemSelected(item);
    }

    public void getAllGenres(String genre) {
        mMovieViewModel.getAllGenres(genre).observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> titles) {
                mAdapter.setMovies(titles);
            }
        });
    }

  //Selected genre------------------------------------------------------------------------------

    @Override
    protected void onStart() {
        super.onStart();

        setUpFiltering();
    }

    public void setUpFiltering() {

        if (mMenuItem != null) {
            genreId = mMenuItem.getItemId();
            Log.d(TAG, "onOptionsItemSelected: " + genreId);
            String genre;

            switch (genreId) {
                case R.id.category_all_genres:
                    mMovieViewModel.getAllTitles().observe(this, new Observer<List<Movie>>() {
                        @Override
                        public void onChanged(@Nullable List<Movie> titles) {
                            mAdapter.setMovies(titles);
                        }
                    });

                    break;
                case R.id.genre_action:
                    genre = "%Action%";
                    getAllGenres(genre);
                    break;
                case R.id.genre_drama:
                    genre = "%Drama%";
                    getAllGenres(genre);
                    break;
                case R.id.genre_comedy:
                    genre = "%Comedy%";
                    getAllGenres(genre);
                    break;
                case R.id.genre_horror:
                    genre = "%Horror%";
                    getAllGenres(genre);
                    break;
            }

        } else {
            mMovieViewModel.getAllTitles().observe(this, new Observer<List<Movie>>() {
                @Override
                public void onChanged(@Nullable List<Movie> titles) {
                    mAdapter.setMovies(titles);
                }
            });

        }

    }
}



