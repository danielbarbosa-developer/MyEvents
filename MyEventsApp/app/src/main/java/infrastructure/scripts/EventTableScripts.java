package infrastructure.scripts;


import entities.LocationModel;
import infrastructure.models.EventTableModel;
import infrastructure.models.LocationTableModel;

public class EventTableScripts {

    public static final String CreateTable(){
        return "CREATE TABLE IF NOT EXISTS " + EventTableModel.TABLE_NAME + " (" +
                EventTableModel._ID + " INTEGER PRIMARY KEY, " +
                EventTableModel.COLUMN_EVENT_NAME + " TEXT, " +
                EventTableModel.COLUMN_EVENT_DATE + " TEXT, " +
                EventTableModel.COLUMN_LOCATION_ID + " INTEGER, " +
                "FOREIGN KEY (" + EventTableModel.COLUMN_LOCATION_ID + ") REFERENCES " +
                LocationTableModel.TABLE_NAME + "(" + LocationTableModel._ID + ")" +
                ");";
    }

    public static final String DeleteTable(){
        return "DROP TABLE IF EXISTS " + EventTableModel.TABLE_NAME + " ;";
    }



}
