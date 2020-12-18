package com.example.finaltodo.Repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.finaltodo.Database.RoomDb;
import com.example.finaltodo.Model.Catmodel;
import com.example.finaltodo.Model.CatmodelDao;
import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.Model.DatamodelDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataFragmentRepo {
//    private ArrayList<Datamodel> dataholder;
//    private HashMap<String, Datamodel> objDetails;
//    String data;
//
//
//    public void setCategory(String s){
//        Log.e("function ","yes");
//        data = s;
////    Datamodel d= new Datamodel();
////    dataholder=new ArrayList<>();
////    d.setCategory(s);
////    dataholder.add(d);
////    return dataholder;
//    }
//
//    public ArrayList<Datamodel> getDatamodel() {
//        Log.e("function ","kiran");
//        if (dataholder == null) {
//            dataholder = new ArrayList<>();
//            Datamodel dm1 =  new Datamodel();
//            dm1.setCategory(data);
//            dm1.setCategoryCount("3");
//            dataholder.add(dm1);
//
//
//            Datamodel dm2 =  new Datamodel();
//            dm2.setCategory("Health");
//            dm2.setCategoryCount("2");
//            dataholder.add(dm2);
//
//            Datamodel dm3 =  new Datamodel();
//            dm3.setCategory("Health");
//            dm3.setCategoryCount("0");
//            dataholder.add(dm3);
//        }
//        return dataholder;
//    }

    private DatamodelDao ddao;
    private CatmodelDao  cdao;
    private LiveData<List<Datamodel>> taskLiveData;
    private LiveData<List<Catmodel>>  catLiveData;

    public DataFragmentRepo(Application application){
        RoomDb db= RoomDb.getDatabase(application);
        ddao=db.ddao();
        taskLiveData=ddao.getTasks();
        RoomDb db2= RoomDb.getDatabase(application);
        cdao=db.cdao();
        catLiveData=cdao.getCategories();
    }
    public void insertTask (Datamodel task){
        RoomDb.databaseWriteExecutor.execute(() -> {
            ddao.insertTask(task);
            Log.e("Testrepo","Repo");
        });
    }
    public void insertCat(Catmodel category){
        RoomDb.databaseWriteExecutor.execute(() -> {
            cdao.insertCat(category);
            Log.e("Testrepo","Repo");
        });
    }
    public void updateTask(Datamodel task) {
        RoomDb.databaseWriteExecutor.execute(() -> {
            ddao.updateTask(task);
        });
    }
    public void updateCat(Catmodel category) {
        RoomDb.databaseWriteExecutor.execute(() -> {
            cdao.updateCat(category);
        });
    }
    public LiveData<List<Datamodel>> getTaskLiveData(){return taskLiveData;}
    public LiveData<List<Catmodel>> getCatLiveData(){return catLiveData;}

}