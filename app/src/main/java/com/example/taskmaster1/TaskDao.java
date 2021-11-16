package com.example.taskmaster1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from TaskOrg")
    List <TaskOrg> getAll();

    @Query("select * from TaskOrg where id = :id")
    TaskOrg findTaskById(int id);

    @Insert
    Long insert(TaskOrg taskOrg);

}
