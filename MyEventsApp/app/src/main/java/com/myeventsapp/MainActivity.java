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
import services.EventsHandler;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final int REQUEST_CODE_NEW_EVENT = 1;
    private final int REQUEST_CODE_EDIT_EVENT = 2;
    private final int RESULT_CODE_NEW_EVENT = 10;
    private final int RESULT_CODE_EDIT_EVENT = 20;
    private int IdCounter = 1;

    private ListView eventsListView;
    private ArrayAdapter<EventModel> eventsAdapter;
    private List<EventModel> eventsLoaded;
    private EventsHandler eventsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MyEvents app");

        eventsHandler = new EventsHandler(getBaseContext());
        eventsLoaded = eventsHandler.GetAllEvents();

        this.eventsListView = findViewById(R.id.EventsListView);
        eventsAdapter = new ArrayAdapter<EventModel>(MainActivity.this, android.R.layout.simple_list_item_1, eventsLoaded);
        eventsListView.setAdapter(eventsAdapter);

        onClickListenerListView();
        onItemLongClickListenerListView();
    }

    public void onClickNewEvent(View v){
        Intent intent = new Intent(MainActivity.this, RegisterEventActivity.class);
        startActivityForResult(intent, REQUEST_CODE_NEW_EVENT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_NEW_EVENT && resultCode == RESULT_CODE_NEW_EVENT){
            EventModel event = (EventModel) data.getExtras().getSerializable("new event");
            event.setId(IdCounter);
            IdCounter++;
            eventsHandler.AddNewEvent(event);
        }else if(requestCode == REQUEST_CODE_EDIT_EVENT && resultCode == RESULT_CODE_EDIT_EVENT){
            EventModel event = (EventModel) data.getExtras().getSerializable("event edition");
            eventsHandler.EditEvent(event.getId(), event);
        }
        eventsLoaded = eventsHandler.GetAllEvents();
        eventsAdapter = new ArrayAdapter<EventModel>(MainActivity.this, android.R.layout.simple_list_item_1, eventsLoaded);
        eventsListView.setAdapter(eventsAdapter);
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void onClickListenerListView(){
        eventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventModel eventClicked = eventsAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, RegisterEventActivity.class);
                intent.putExtra("event edition", eventClicked);
                startActivityForResult(intent, REQUEST_CODE_EDIT_EVENT);
            }
        });
    }

    private void onItemLongClickListenerListView(){
        eventsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                EventModel eventClicked = eventsAdapter.getItem(position);
                eventsHandler.DeleteEvent(eventClicked.getId());
                eventsLoaded = eventsHandler.GetAllEvents();
                eventsAdapter = new ArrayAdapter<EventModel>(MainActivity.this, android.R.layout.simple_list_item_1, eventsLoaded);
                eventsListView.setAdapter(eventsAdapter);
                return true;
            }
        });
    }
}