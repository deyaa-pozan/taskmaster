package com.example.taskmaster1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from task")
    List <Task> getAll();

    @Query("select * from task where id = :id")
    Task findTaskById(int id);

    @Insert
    Long insert(Task task);

}
