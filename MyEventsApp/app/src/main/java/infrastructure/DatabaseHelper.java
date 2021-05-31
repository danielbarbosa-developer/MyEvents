package infrastructure;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import infrastructure.models.EventTableModel;
import infrastructure.scripts.EventTableScripts;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String _databaseName = "db.events";
    private static final int _databaseVersion = 1;


    public DatabaseHelper(@Nullable Context context) {
        super(context, _databaseName, null, _databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EventTableScripts.CreateTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EventTableScripts.DeleteTable());
        db.execSQL(EventTableScripts.CreateTable());
    }
}
