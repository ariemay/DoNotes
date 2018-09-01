package com.ariemay.donotes;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.EditText;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase mDb;
    private EditText mTodoInput;
    private EditText mPriorityCount;
    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView todoListRecycleview;

        mTodoInput = (EditText) this.findViewById(R.id.todo_input);
        mPriorityCount = (EditText) this.findViewById(R.id.priority_count);
        todoListRecycleview = (RecyclerView) this.findViewById(R.id.todoListRecycleView);

        todoListRecycleview.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addTodoList(View view) {
    }
}
