package infrastructure.scripts;

import infrastructure.models.LocationTableModel;

public class LocationTableScripts {

    public static final String CreateTable(){
        return "CREATE TABLE IF NOT EXISTS " + LocationTableModel.TABLE_NAME + " (" +
                LocationTableModel._ID + " INTEGER PRIMARY KEY, " +
                LocationTableModel.COLUMN_LOCATION_NAME + " TEXT, " +
                LocationTableModel.COLUMN_LOCATION_DISTRICT + " TEXT, " +
                LocationTableModel.COLUMN_LOCATION_CITY + " TEXT, " +
                LocationTableModel.COLUMN_LOCATION_CAPACITY + " INTEGER " +
                ");";
    }

    public static final String DeleteTable(){
        return "DROP TABLE IF EXISTS " + LocationTableModel.TABLE_NAME + " ;";
    }
}
