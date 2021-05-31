package infrastructure.scripts;


import infrastructure.models.EventTableModel;

public class EventTableScripts {

    public static final String CreateTable(){
        return "CREATE TABLE IF NOT EXISTS " + EventTableModel.TABLE_NAME + " (" +
                EventTableModel._ID + " INTEGER PRIMARY KEY, " +
                EventTableModel.COLUMN_EVENT_NAME + " TEXT, " +
                EventTableModel.COLUMN_EVENT_DATE + " TEXT, " +
                EventTableModel.COLUMN_EVENT_LOCATION + " TEXT " +
                ");";
    }

    public static final String DeleteTable(){
        return "DROP TABLE IF EXISTS " + EventTableModel.TABLE_NAME + " ;";
    }



}
