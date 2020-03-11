package com.architecturecomponent.lifecycleaware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Heyy", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
        final TextView randnum = findViewById(R.id.random_number_text);
        Button button = findViewById(R.id.button);
        final MainActivityViewModel viewModelProviders = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        final LiveData<String> myRandomNumber = viewModelProviders.getNumber();
        myRandomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                randnum.setText(s);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModelProviders.createNumber();
            }
        });

        Log.i(TAG, "Random Number Set");
        Log.d(TAG, "onCreate Owner");
        getLifecycle().addObserver(new MainActivityObserver());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart Owner");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop Owner");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy Owner");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause Owner");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume Owner");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart Owner");
    }
}
