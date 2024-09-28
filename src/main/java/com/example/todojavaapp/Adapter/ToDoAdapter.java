package com.example.todojavaapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todojavaapp.MainActivity;
import com.example.todojavaapp.Modals.ToDoModal;
import com.example.todojavaapp.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {
    private List<ToDoModal> todoList;
    private MainActivity activity;

    // Constructor to initialize the activity and list
    public ToDoAdapter(MainActivity activity, List<ToDoModal> todoList) {
        this.activity = activity;
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);  // Return your custom ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the item at the current position
        ToDoModal item = todoList.get(position);

        // Bind the data to the views
        holder.checkBox.setText(item.getTask());
        holder.checkBox.setChecked(item.getStatus());
    }

    // Method to update the task list and notify the adapter
    public void setTask(List<ToDoModal> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();  // Notify the adapter that the data has changed
    }

    @Override
    public int getItemCount() {
        return todoList.size();  // Return the size of the todo list
    }

    // ViewHolder class to hold the views for each item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Initialize the CheckBox from the layout
            checkBox = itemView.findViewById(R.id.checkbox);
        }
    }
}
