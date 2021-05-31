package repository;

import abstractions.IRepository;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import entities.EventModel;
import infrastructure.DatabaseGateway;
import infrastructure.models.EventTableModel;

import java.util.ArrayList;
import java.util.List;

public class EventsRepositorySQLite implements IRepository {

    private DatabaseGateway dbGateway;

    public EventsRepositorySQLite(Context content) {
        this.dbGateway = DatabaseGateway.getInstance(content);
    }

    @Override
    public List<EventModel> GetAllEvents() {
        List<EventModel> list = new ArrayList<EventModel>();
        Cursor cursor = dbGateway.getDatabase().rawQuery("SELECT * FROM " + EventTableModel.TABLE_NAME, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(EventTableModel._ID));
            String name = cursor.getString(cursor.getColumnIndex(EventTableModel.COLUMN_EVENT_NAME));
            String date = cursor.getString(cursor.getColumnIndex(EventTableModel.COLUMN_EVENT_DATE));
            String location = cursor.getString(cursor.getColumnIndex(EventTableModel.COLUMN_EVENT_LOCATION));

            list.add(new EventModel(id, name, date, location));
        }
        cursor.close();
        return list;
    }

    @Override
    public void AddNewEvent(EventModel event) {
        ContentValues values = new ContentValues();
        values.put(EventTableModel.COLUMN_EVENT_NAME, event.getEventName());
        values.put(EventTableModel.COLUMN_EVENT_DATE, event.getDate());
        values.put(EventTableModel.COLUMN_EVENT_LOCATION, event.getLocation());

        dbGateway.getDatabase().insert(EventTableModel.TABLE_NAME, null, values);
    }

    @Override
    public void EditEvent(int eventId, EventModel event) {
        ContentValues values = new ContentValues();
        values.put(EventTableModel.COLUMN_EVENT_NAME, event.getEventName());
        values.put(EventTableModel.COLUMN_EVENT_DATE, event.getDate());
        values.put(EventTableModel.COLUMN_EVENT_LOCATION, event.getLocation());

        dbGateway.getDatabase().update(EventTableModel.TABLE_NAME, values, EventTableModel._ID + "=?", new String[] {String.valueOf(eventId)});
    }
}
