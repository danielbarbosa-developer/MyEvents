package infrastructure.models;

import android.provider.BaseColumns;

public class LocationTableModel implements BaseColumns {

    private LocationTableModel() { }

    public static final String TABLE_NAME = "Events";

    public static final String COLUMN_LOCATION_NAME = "Location_name";

    public static final String COLUMN_LOCATION_DISTRICT = "District";

    public static final String COLUMN_LOCATION_CITY = "City";

    public static final String COLUMN_LOCATION_CAPACITY = "Capacity";
}
