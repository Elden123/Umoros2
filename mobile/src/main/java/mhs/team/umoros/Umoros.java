package mhs.team.umoros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import java.net.HttpURLConnection;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClientBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Umoros extends AppCompatActivity {

    private TextView tweetDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_search);

        tweetDisplay = (TextView)findViewById(R.id.tweet_txt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_umoros, menu);
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

    public void searchTwitter(View view){
        EditText searchTxt = (EditText)findViewById(R.id.search_edit);
        String searchTerm = searchTxt.getText().toString();
        if(searchTerm.length()>0){

        }
        else
            tweetDisplay.setText("Enter a search query!");

        try{
            String encodedSearch = URLEncoder.encode(searchTerm, "UTF-8");
            String searchURL = "http://search.twitter.com/search.json?q="+encodedSearch;
        }
        catch(Exception e){
            tweetDisplay.setText("Whoops - something went wrong!");
            e.printStackTrace();
        }
    }
}
