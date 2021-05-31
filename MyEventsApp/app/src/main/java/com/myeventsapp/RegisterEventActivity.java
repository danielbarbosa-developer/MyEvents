package com.myeventsapp;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import entities.EventModel;
import services.EventsHandler;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RegisterEventActivity extends AppCompatActivity {

    private final int RESULT_CODE_NEW_EVENT = 10;
    private final int RESULT_CODE_EDIT_EVENT = 20;
    private boolean Editing = false;
    private int Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_event_activity);

        loadEvent();

    }

    private void loadEvent(){
        Intent intent = getIntent();

        if(intent != null && intent.getExtras() != null && intent.getExtras().get("event edition") != null){
            EventModel event = (EventModel) intent.getExtras().get("event edition");

            EditText textName = findViewById(R.id.textNameInput);
            EditText textDate = findViewById(R.id.textDateInput);
            EditText textLocation = findViewById(R.id.textLocationInput);

            textName.setText(event.getEventName());
            textDate.setText(event.getDate());
            textLocation.setText(event.getLocation());
            Editing = true;
            Id = event.getId();
        }
    }
    public void onClickCancel(View v){
        finish();
    }

    public void onClickSave(View v) throws ParseException {
        EditText textName = findViewById(R.id.textNameInput);
        EditText textDate = findViewById(R.id.textDateInput);
        EditText textLocation = findViewById(R.id.textLocationInput);

        String eventName = textName.getText().toString();

        String eventDate = textDate.getText().toString();

        String eventLocation = textLocation.getText().toString();

        Intent intent = new Intent();
        EventModel event = new EventModel(Id ,eventName, eventDate, eventLocation);

        if(Editing){
            intent.putExtra("event edition", event);
            setResult(RESULT_CODE_EDIT_EVENT, intent);
        }else {
            intent.putExtra("new event", event);
            setResult(RESULT_CODE_NEW_EVENT, intent);
        }
        finish();

    }
}