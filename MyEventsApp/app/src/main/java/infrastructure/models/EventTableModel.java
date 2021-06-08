package infrastructure.models;

import android.provider.BaseColumns;

public class EventTableModel implements BaseColumns {

    private EventTableModel() { }

    public static final String TABLE_NAME = "Events";

    public static final String COLUMN_EVENT_NAME = "Event_name";

    public static final String COLUMN_EVENT_DATE = "Date";

    public static final String COLUMN_LOCATION_ID = "Location_Id";

}
