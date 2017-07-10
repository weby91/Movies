package com.webster.udacity.movies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.webster.udacity.movies.fragments.MainActivityFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_container);

        if(findViewById(R.id.flContainer) != null)
        {
            if(savedInstanceState != null)
                return;

            initUi();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_filter:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.flContainer, MainActivityFragment.newInstance(null)).commit();
                break;
            default:
                break;
        }

        return true;
    }

    private void initUi() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.flContainer, MainActivityFragment.newInstance(null)).commit();
    }
}
