package repository;

import abstractions.ILocalRepository;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import entities.EventModel;
import entities.LocationModel;
import infrastructure.models.EventTableModel;
import infrastructure.models.LocationTableModel;
import infrastructure.DatabaseGateway;

import java.util.ArrayList;
import java.util.List;

public class LocationsRepositorySQLite implements ILocalRepository {

    private DatabaseGateway dbGateway;

    public LocationsRepositorySQLite(Context content) {
        this.dbGateway = DatabaseGateway.getInstance(content);
    }

    @Override
    public List<LocationModel> GetAllLocations() {
        List<LocationModel> list = new ArrayList<LocationModel>();
        String sql = "SELECT * FROM " + LocationTableModel.TABLE_NAME;
        Cursor cursor = dbGateway.getDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()){
            int locationId = cursor.getInt(cursor.getColumnIndex(LocationTableModel._ID));
            String localName = cursor.getString(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_NAME));
            String district = cursor.getString(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_DISTRICT));
            String city = cursor.getString(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_CITY));
            int capacity = cursor.getInt(cursor.getColumnIndex(LocationTableModel.COLUMN_LOCATION_CAPACITY));

            list.add(new LocationModel(locationId, localName, district, city, capacity));
        }
        cursor.close();
        return list;
    }

    @Override
    public void AddNewLocation(LocationModel local) {
        ContentValues values = new ContentValues();
        values.put(LocationTableModel.COLUMN_LOCATION_NAME, local.getName());
        values.put(LocationTableModel.COLUMN_LOCATION_DISTRICT, local.getDistrict());
        values.put(LocationTableModel.COLUMN_LOCATION_CITY, local.getCity());
        values.put(LocationTableModel.COLUMN_LOCATION_CAPACITY, local.getCapacity());

        dbGateway.getDatabase().insert(LocationTableModel.TABLE_NAME, null, values);
    }

    @Override
    public void EdiLocation(int localId, LocationModel local) {
        ContentValues values = new ContentValues();
        values.put(LocationTableModel.COLUMN_LOCATION_NAME, local.getName());
        values.put(LocationTableModel.COLUMN_LOCATION_DISTRICT, local.getDistrict());
        values.put(LocationTableModel.COLUMN_LOCATION_CITY, local.getCity());
        values.put(LocationTableModel.COLUMN_LOCATION_CAPACITY, local.getCapacity());

        dbGateway.getDatabase().update(LocationTableModel.TABLE_NAME, values, LocationTableModel._ID + "=?", new String[] {String.valueOf(localId)});
    }

    @Override
    public void DeleteLocation(int localId) {
        dbGateway.getDatabase().delete(LocationTableModel.TABLE_NAME, LocationTableModel._ID + "=?", new String[] {String.valueOf(localId)});
    }
}
