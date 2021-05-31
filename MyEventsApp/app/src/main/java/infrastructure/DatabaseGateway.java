package infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseGateway {

    private SQLiteDatabase database;
    private static DatabaseGateway dbGateway;

    public static DatabaseGateway getInstance(Context context){

        if(dbGateway == null)
            dbGateway = new DatabaseGateway(context);

        return dbGateway;
    }

    public DatabaseGateway(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        this.database = dbHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDatabase(){
        return database;
    }
}
