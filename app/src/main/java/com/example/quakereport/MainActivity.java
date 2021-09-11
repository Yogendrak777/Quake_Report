package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ArrayList<earthword> earthquakes = QueryUtils.extractEarthwork();

        ListView earthquake = (ListView) findViewById(R.id.list);

        final earthAdapter adapter = new earthAdapter(this,earthquakes);

        earthquake.setAdapter(adapter);

        earthquake.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                earthword pos = adapter.getItem(position);
                Uri earthquakeUri = Uri.parse(pos.getMurl());
                Intent intent = new Intent(Intent.ACTION_VIEW,earthquakeUri);
                startActivity(intent);
            }
        });
    }
}