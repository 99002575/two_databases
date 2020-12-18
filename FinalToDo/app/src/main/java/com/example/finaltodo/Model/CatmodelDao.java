package com.example.finaltodo.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface CatmodelDao {
    @Insert
    void insertCat(Catmodel data);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * FROM Category_table ORDER BY category ASC")
    LiveData<List<Catmodel>> getCategories();

    @Update
    void updateCat(Catmodel data);
}
