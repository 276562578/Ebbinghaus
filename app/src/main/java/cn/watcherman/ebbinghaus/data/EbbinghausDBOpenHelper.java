package cn.watcherman.ebbinghaus.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cn.watcherman.ebbinghaus.data.EbbinghausContract.contentEntry;


/**
 * Created by minecraft on 17-3-9.
 */
public class EbbinghausDBOpenHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Ebbinghaus.db";

    public EbbinghausDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + contentEntry.TABLE_NAME +
                " (" + contentEntry._ID + " INTEGER PRIMARY KEY," +
                contentEntry.COLUMN_CONTENT + " TEXT NOT NULL," +
                contentEntry.COLUMN_SET_DATE + " TEXT NOT NULL," +
                contentEntry.COLUMN_NEXT_TIMES_DATE +" TEXT," +
                contentEntry.COLUMN_EXEC_TIMES + " INTEGER DEFAULT 0" + ")";
        db.execSQL(SQL_CREATE_ENTRIES);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

}
