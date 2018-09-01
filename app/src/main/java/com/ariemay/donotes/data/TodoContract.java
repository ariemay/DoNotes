package com.ariemay.donotes.data;

import android.provider.BaseColumns;

/**
 * Created by Arie on 9/1/2018.
 */

public class TodoContract {

    public static final class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "TodoList";
        public static final String COLUMN_TODO = "todo";
        public static final String COLUMN_PRIORITY = "priorityNumber";
    }
}
