package com.example.todojavaapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todojavaapp.Adapter.ToDoAdapter;
import com.example.todojavaapp.Modals.ToDoModal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycleMain;
    private ToDoAdapter taskAdapter;
    private List<ToDoModal> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        taskList = new ArrayList<>();
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView and set layout manager
        recycleMain = findViewById(R.id.recyclemain);
        recycleMain.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the adapter with the task list
        taskAdapter = new ToDoAdapter(this, taskList);
        recycleMain.setAdapter(taskAdapter);

        // Create a task and add it to the task list
        ToDoModal task = new ToDoModal();
        task.setTask("This is Anuj");
        task.setStatus(false); // Set the status to false (unchecked)
        task.setId(1);

        // Add the task multiple times for demonstration
        for (int i = 0; i < 6; i++) {
            taskList.add(task);
        }

        // Notify the adapter that the task list has changed
        taskAdapter.setTask(taskList);
    }
}
