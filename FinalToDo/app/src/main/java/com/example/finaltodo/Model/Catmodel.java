package com.example.finaltodo.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Category_table")
public class Catmodel{

    @PrimaryKey(autoGenerate = true)
    private int CatId;
    String category;
//    String categoryCount;
    boolean addTask;
//    public void setCategoryCount(String categoryCount) {
//        this.categoryCount = categoryCount;
//    }
//
//    public String getCategoryCount() {
//        return categoryCount;
//    }

    public void setCatId(int CatId){this.CatId=CatId;}
    public int getCatId(){return CatId;}

    public void setAddTask(boolean addTask) {
        this.addTask = addTask;
    }

    public boolean getAddTask() {
        return addTask;
    }

    public Catmodel(String category){this.category=category;}

    public String getCategory(){return category;}


}