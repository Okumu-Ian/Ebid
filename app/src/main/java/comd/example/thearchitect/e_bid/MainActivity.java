package comd.example.thearchitect.e_bid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import adapters.ProductsAdapter;
import models.ProductsModel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private ProductsAdapter adapter;
    private List<ProductsModel> list;
    private ProductsModel model;
    private static String web_url = "https://yts.am/api/v2/list_movies.json?limit=15";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }



    private void initUI()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        list = new ArrayList<>();
        recyclerView = findViewById(R.id.list_items);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        /*loadData();*/
        getData(web_url);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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


    private void loadData()
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(web_url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try
                {

                    JSONObject jsonObject = response.getJSONObject("data");
                    JSONArray array = jsonObject.getJSONArray("movies");
                    for (int i=0;i<array.length();i++)
                    {
                        model = new ProductsModel();
                        JSONObject object = array.getJSONObject(i);
                        model.setImage_url(object.getString("large_cover_image"));
                        model.setProduct_name(object.getString("title_english"));
                        list.add(model);
                        adapter = new ProductsAdapter(list,MainActivity.this,MainActivity.this);
                        recyclerView.setAdapter(adapter);

                    }



                }catch (JSONException exception)
                {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(MainActivity.this).add(jsonObjectRequest);

    }


    private void getData(String url)

    {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {

                    JSONObject jsonObject = new JSONObject(response);

                    JSONObject data1 = jsonObject.getJSONObject("data");

                    JSONArray jsonArray = data1.getJSONArray("movies");

                    for(int x = 0; x<jsonArray.length();x++)
                    {
                        model = new ProductsModel();
                        JSONObject data = jsonArray.getJSONObject(x);
                        model.setImage_url(data.getString("medium_cover_image"));
                        list.add(model);
                        adapter = new ProductsAdapter(list,MainActivity.this,MainActivity.this);
                        recyclerView.setAdapter(adapter);

                    }

                }catch (JSONException json)
                {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Toast.makeText(this, item.getTitle()+" coming soon.", Toast.LENGTH_SHORT).show();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
