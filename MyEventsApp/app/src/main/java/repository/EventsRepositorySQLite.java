package repository;

import abstractions.IRepository;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import entities.EventModel;
import entities.LocationModel;
import infrastructure.DatabaseGateway;
import infrastructure.models.EventTableModel;
import infrastructure.models.LocationTableModel;

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
        String sql = "SELECT * FROM " + EventTableModel.TABLE_NAME + " INNER JOIN " + LocationTableModel.TABLE_NAME +
                " ON " + EventTableModel.COLUMN_LOCATION_ID + " = " + LocationTableModel._ID;
        Cursor cursor = dbGateway.getDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(EventTableModel._ID));
            String name = cursor.getString(cursor.getColumnIndex(EventTableModel.COLUMN_EVENT_NAME));
            String date = cursor.getString(cursor.getColumnIndex(EventTableModel.COLUMN_EVENT_DATE));
            int locationId = cursor.getInt(cursor.getColumnIndex(EventTableModel.COLUMN_LOCATION_ID));
            String localName = cursor.getString(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_NAME));
            String district = cursor.getString(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_DISTRICT));
            String city = cursor.getString(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_CITY));
            int capacity = cursor.getInt(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_CAPACITY));

            LocationModel location = new LocationModel(locationId, localName, district, city, capacity);
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
        values.put(EventTableModel.COLUMN_LOCATION_ID, event.getLocation().getId());

        dbGateway.getDatabase().insert(EventTableModel.TABLE_NAME, null, values);
    }

    @Override
    public void EditEvent(int eventId, EventModel event) {
        ContentValues values = new ContentValues();
        values.put(EventTableModel.COLUMN_EVENT_NAME, event.getEventName());
        values.put(EventTableModel.COLUMN_EVENT_DATE, event.getDate());
        values.put(EventTableModel.COLUMN_LOCATION_ID, event.getLocation().getId());

        dbGateway.getDatabase().update(EventTableModel.TABLE_NAME, values, EventTableModel._ID + "=?", new String[] {String.valueOf(eventId)});
    }

    @Override
    public void DeleteEvent(int eventId) {
        dbGateway.getDatabase().delete(EventTableModel.TABLE_NAME, EventTableModel._ID + "=?", new String[] {String.valueOf(eventId)});
    }
}
