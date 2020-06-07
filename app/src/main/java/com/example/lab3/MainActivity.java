package com.example.lab3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.provider.MediaStore;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();
                Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja, REQUEST_IMAGE_CAPTURE);
            }
        });
    }

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

        switch(id) {
            case R.id.action_settings:
                Toast.makeText(this, "Kliknięto Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings2:
                Toast.makeText(this, "Kliknięto Settings2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings3:
                Toast.makeText(this, "Kliknięto Settings3", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, "Cos kliknięto", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout) findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(), imageBitmap));
    }

    public void kliknij (View view) {
        Toast.makeText(getApplicationContext(), "Kliknięto przycisk Button", Toast.LENGTH_SHORT).show();
        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    public void wylosujIkone (View view) {
        int rand = new Random().nextInt() % 5;

        ImageButton ikona = (ImageButton) view;

        if (rand == 0) {
            ikona.setImageDrawable(getResources().getDrawable(R.drawable.wi, getTheme()));
        } else if (rand == 1) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_dialog_email, getTheme()));
        } else if (rand == 2) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_media_ff, getTheme()));
        } else if (rand == 3) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.ic_media_play, getTheme()));
        } else if (rand == 4) {
            ikona.setImageDrawable(getResources().getDrawable(android.R.drawable.arrow_up_float, getTheme()));
        }
    }
}