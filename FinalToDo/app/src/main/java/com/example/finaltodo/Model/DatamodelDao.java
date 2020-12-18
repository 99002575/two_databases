package com.example.finaltodo.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface DatamodelDao {
    @Insert
    void insertTask(Datamodel data);

    @Query("DELETE FROM Task_table")
    void deleteAll();

    @Query("SELECT * FROM Task_table ORDER BY taskTitle ASC")
    LiveData<List<Datamodel>> getTasks();

    @Update
    void updateTask(Datamodel data);

//    @Query("SELECT * FROM Task_table WHERE Task_table.category == Category_table.category ")
}

