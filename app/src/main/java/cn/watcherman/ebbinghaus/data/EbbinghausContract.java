package cn.watcherman.ebbinghaus.data;

import android.provider.BaseColumns;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by minecraft on 17-3-10.
 */
public final class EbbinghausContract {
    private EbbinghausContract() {
    }

    public static class contentEntry implements BaseColumns {
        public static final String TABLE_NAME = "content";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_SET_DATE = "set_date";
        public static final String COLUMN_EXEC_TIMES = "exec_times";
        public static final String COLUMN_NEXT_TIMES_DATE = "next_times_date";


    }

    public static class usualConstant {
        public static final String DATE_NOW = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Calendar.getInstance().getTime());
    }

}
