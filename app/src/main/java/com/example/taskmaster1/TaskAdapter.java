package com.example.taskmaster1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{//
//    List<Task> tasks = new ArrayList<>();
//    Context context;
//
//    public TaskAdapter(List<Task> tasks, Context context) {
//        this.context = context;
//        this.tasks = tasks;
//    }
//
//    public static class TaskViewHolder extends RecyclerView.ViewHolder{
//
//
//        TextView titleT, bodyT, stateT;
//        View itemView;
//        public TaskViewHolder(@NonNull View itemView) {
//            super(itemView);
//            this.itemView = itemView;
//            titleT = itemView.findViewById(R.id.fragment_title_text);
//            bodyT = itemView.findViewById(R.id.fragment_body_text);
//            stateT = itemView.findViewById(R.id.fragment_state_text);
//        }
//    }
//
//
//    @NonNull
//    @Override
//    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task,parent,false);
//
//        return new TaskViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
//        Task task = tasks.get(position);
//        holder.titleT.setText(task.getTitle());
//        holder.bodyT.setText(task.getBody());
//        holder.stateT.setText(task.getState().toString());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent taskDetailsIntent = new Intent(context, OneTaskActivity.class);
//                taskDetailsIntent.putExtra("taskName",task.getTitle());
//                context.startActivity(taskDetailsIntent);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return tasks.size();
//    }
//}


    List<Task> allTasksData = new ArrayList<>();


    public TaskAdapter(List<Task> allTasksData) {
        this.allTasksData = allTasksData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_list_item, parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Context context = viewHolder.itemView.getContext();

        Task task= allTasksData.get(position);
        viewHolder.textViewTitle.setText(task.getTitle());
        viewHolder.textViewBody.setText(task.getBody());
        viewHolder.textViewState.setText(task.getState()+"");
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("my Adapter", "Element "+ viewHolder.getAdapterPosition() + " clicked");

                String Task1 =viewHolder.textViewTitle.getText().toString();
                editor.putString("TaskName",Task1);
                editor.apply();
                Intent gotToStd = new Intent(context,OneTaskActivity.class);
                context.startActivity(gotToStd);
//
            }


        });

    }

    @Override
    public int getItemCount() {
        return allTasksData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewTitle;
        public TextView textViewBody;
        public TextView textViewState;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle= (TextView)  itemView.findViewById(R.id.title);
            textViewBody= (TextView)  itemView.findViewById(R.id.body);
            textViewState= (TextView)  itemView.findViewById(R.id.state);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.layout);

        }
    }
}
