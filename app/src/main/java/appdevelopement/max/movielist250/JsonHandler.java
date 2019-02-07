package appdevelopement.max.movielist250;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class JsonHandler {

    private static final String TAG = "OMDbLoopjTask";
    Movie movie;

    public interface OnJsonCompleted {
        void taskMovieCompleted(Movie results);
    }

    AsyncHttpClient asyncHttpClient;
    RequestParams requestParams;
    Context context;
    OnJsonCompleted mOnJsonCompleted;

    String BASE_URL = "http://www.omdbapi.com/?apikey=ca9c6abf&t=";

    public JsonHandler(Context context, OnJsonCompleted listener) {
        asyncHttpClient = new AsyncHttpClient();
        requestParams = new RequestParams();
        this.context = context;
        this.mOnJsonCompleted = listener;
    }

    public void executeLoopjCall(String queryTerm, final int rank) {
        queryTerm = handleExeption(queryTerm);
        Log.d(TAG, "executeLoopjCall: " + queryTerm);
        requestParams.put("s", queryTerm);
        asyncHttpClient.get(BASE_URL + queryTerm, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    movie = new Movie();
                    movie.setTitle(response.getString("Title"));
                    movie.setDirector(response.getString("Director"));
                    movie.setActors(response.getString("Actors"));
                    movie.setYear(response.getString("Year"));
                    movie.setRating(response.getDouble("imdbRating"));
                    movie.setRank(rank);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mOnJsonCompleted.taskMovieCompleted(movie);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.e(TAG, "onFailure: " + errorResponse);
            }
        });
    }

    public String handleExeption(String queryTerm) {
        if (queryTerm.equals("Taare Zameen Par")) {
            return "Like Stars on Earth";
    }
        return queryTerm;
    }
}
