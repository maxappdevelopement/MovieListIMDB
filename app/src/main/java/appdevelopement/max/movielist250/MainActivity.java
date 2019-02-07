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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonHandler.OnJsonCompleted {

    private JsonHandler mJsonHandler;
    public static MovieViewModel mMovieViewModel;
    private List<String> top250List;

    @Override
    public void taskMovieCompleted(Movie results) {
      mMovieViewModel.insert(results);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mJsonHandler = new JsonHandler(this, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final MovieListAdapter adapter = new MovieListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMovieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        mMovieViewModel.getAllTitles().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> titles) {
                adapter.setMovies(titles);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LiveData<List<Movie>> getTitles = mMovieViewModel.getAllTitles();

                //Log.d("VAFAN", "onClick: " + getTitles.getValue().get(2).getTitle());

                for (int i = 0; i < getTitles.getValue().size(); i++) {
                    String movie = getTitles.getValue().get(i).getTitle();
                    int rank = getTitles.getValue().get(i).getRank();
                    mJsonHandler.executeLoopjCall(movie, rank);
                }

            }
        });
    }


    //TOOLBAR SETUP------------------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}



