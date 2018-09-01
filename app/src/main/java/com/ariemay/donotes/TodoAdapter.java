package com.ariemay.donotes;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ariemay.donotes.data.TodoContract;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private Cursor mCursor;
    private Context mContext;

    public TodoAdapter(Cursor mCursor, Context mContext) {
        this.mCursor = mCursor;
        this.mContext = mContext;
    }


    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.activity_todo_adapter, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        if (!mCursor.moveToPosition(position)) {
            return;
        }

        String todo = mCursor.getString(mCursor.getColumnIndex(TodoContract.TodoEntry.COLUMN_TODO));
        int priority = mCursor.getInt(mCursor.getColumnIndex(TodoContract.TodoEntry.COLUMN_PRIORITY));
        long id = mCursor.getLong(mCursor.getColumnIndex(TodoContract.TodoEntry._ID));

        holder.todoText.setText(todo);
        holder.priorityNumber.setText(String.valueOf(priority));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }
        mCursor = newCursor;
        if (newCursor != null) {
            this.notifyDataSetChanged();
        }
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        TextView todoText;
        TextView priorityNumber;

        public TodoViewHolder(View view) {
            super(view);
            todoText = (TextView) view.findViewById(R.id.todoText);
            priorityNumber = (TextView) view.findViewById(R.id.priorityNumber);
        }
    }
}
