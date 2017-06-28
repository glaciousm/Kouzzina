package gr.kouzzzina.kouzzinaApp;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.gson.Gson;

import gr.kouzzzina.kouzzinaApp.Adapter.FeedAdapter;
import gr.kouzzzina.kouzzinaApp.Common.HTTPDataHandler;
import gr.kouzzzina.kouzzinaApp.Model.RSSObject;
import gr.kouzzzina.kouzzinaApp.retrofit.APIClient;
import gr.kouzzzina.kouzzinaApp.retrofit.APIClient;
import gr.kouzzzina.kouzzinaApp.retrofit.APIInterface;
import gr.kouzzzina.kouzzinaApp.retrofit.model.Entity;
import gr.kouzzzina.kouzzinaApp.retrofit.model.ImageEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.android.gms.ads.MobileAds;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    RSSObject rssObject;
    private AdView mAdView;

    //RSS link
    private final String RSS_link="http://www.kouzzzina.gr/feed/";
    private final String RSS_to_Json_API = "https://api.rss2json.com/v1/api.json?rss_url=";

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println(isNetworkConnected());
        if (!isNetworkConnected()){
            System.out.println("Inside");
            Toast.makeText(MainActivity.this, "No internet connection", Toast.LENGTH_SHORT).show();
            finish();
        } else {

        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "YOUR_ADMOB_APP_ID");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        toolbar.setTitle("Νέες Συνταγές");
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        /*Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://kouzzzina.gr").addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        APIInterface inter = retrofit.create(APIInterface.class);
        Call<List<Entity>> call = inter.doGetListResources();

        call.enqueue(new Callback<List<Entity>>() {
            @Override
            public void onResponse(Call<List<Entity>> call, Response<List<Entity>> response) {
                List<Entity> entity = response.body();

                System.out.println("General Entity = " + entity);
            }

            @Override
            public void onFailure(Call<List<Entity>> call, Throwable t) {
                System.out.println("ERROR // " +  t.toString());
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "error!!!!", Toast.LENGTH_SHORT).show();
            }
        });

        Call<List<ImageEntity>> call1 = inter.doGetListSearch("3271");
        call1.enqueue(new Callback<List<ImageEntity>>() {
            @Override
            public void onResponse(Call<List<ImageEntity>> call1, Response<List<ImageEntity>> response) {
                List<ImageEntity> entity = response.body();

                System.out.println("Image Entity = " + entity);
            }

            @Override
            public void onFailure(Call<List<ImageEntity>> call1, Throwable t) {
                System.out.println("ERROR // " +  t.toString());
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "error!!!!", Toast.LENGTH_SHORT).show();
            }
        });*/

            loadRSS();
    }}

    private void loadRSS() {
        AsyncTask<String,String,String> loadRSSAsync = new AsyncTask<String, String, String>() {

            ProgressDialog mDialog = new ProgressDialog(MainActivity.this);

            @Override
            protected void onPreExecute() {

               mDialog.setMessage("Please wait...");
                mDialog.show();
            }

            @Override
            protected String doInBackground(String... params) {
                String result;
                HTTPDataHandler http = new HTTPDataHandler();
                result = http.GetHTTPData(params[0]);
                return  result;
            }

            @Override
            protected void onPostExecute(String s) {
                mDialog.dismiss();
                rssObject = new Gson().fromJson(s,RSSObject.class);
                FeedAdapter adapter = new FeedAdapter(rssObject,getBaseContext());


                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        };

        StringBuilder url_get_data = new StringBuilder(RSS_to_Json_API);
        url_get_data.append(RSS_link);
        loadRSSAsync.execute(url_get_data.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_refresh)
            loadRSS();
        return true;
    }
}