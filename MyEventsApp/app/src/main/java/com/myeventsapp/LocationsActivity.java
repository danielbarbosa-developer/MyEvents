package com.myeventsapp;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import entities.EventModel;
import entities.LocationModel;
import services.LocationsHandler;

import java.util.List;

public class LocationsActivity extends AppCompatActivity {

    private final int REQUEST_CODE_NEW_LOCATION = 1;
    private final int REQUEST_CODE_EDIT_LOCATION = 2;
    private final int RESULT_CODE_NEW_LOCATION = 10;
    private final int RESULT_CODE_EDIT_LOCATION = 20;

    private ListView locationsListView;
    private ArrayAdapter<LocationModel> locationsAdapter;
    private List<LocationModel> locationsLoaded;
    private LocationsHandler locationsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        locationsHandler = new LocationsHandler(getBaseContext());
        locationsLoaded = locationsHandler.GetAllLocations();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        this.locationsListView = findViewById(R.id.LocationsListView);
        locationsAdapter = new ArrayAdapter<LocationModel>(LocationsActivity.this, android.R.layout.simple_list_item_1, locationsLoaded);
        locationsListView.setAdapter(locationsAdapter);
    }

    public void onClickNewLocation(View v){
        Intent intent = new Intent(LocationsActivity.this, RegisterLocationActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NEW_LOCATION);
    }
}