package com.example.finaltodo.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.finaltodo.Model.Catmodel;
import com.example.finaltodo.Model.Datamodel;
import com.example.finaltodo.Repo.DataFragmentRepo;

import java.util.ArrayList;
import java.util.List;

public class FragmentViewModel  extends AndroidViewModel {
//    private LiveData<String> selectedDatamodel= new LiveData<>();
     private DataFragmentRepo repo;
    private DataFragmentRepo dataRepository;
    private LiveData<List<Datamodel>> todoLiveData;
    private LiveData<List<Catmodel>> catLiveData;


    public FragmentViewModel(@NonNull Application application){
        super(application);
        repo=new DataFragmentRepo(application);
        dataRepository = new DataFragmentRepo(application);
        todoLiveData = dataRepository.getTaskLiveData();
        catLiveData=dataRepository.getCatLiveData();
    }
    public void insertTask(Datamodel task){
        Log.e("TestViewm","VM");
        repo.insertTask(task);}

    public void insertCat(Catmodel category){
        Log.e("TestViewm","VM");
        repo.insertCat(category);}


//    public void selectDatamodel(String categoryName){
//        selectedDatamodel.setValue(categoryName);
//    }

    public LiveData<List<Datamodel>> getTaskLiveData() {
        return todoLiveData;
    }
    public LiveData<List<Catmodel>> getCatLiveData(){return catLiveData;}


//    public LiveData<String> getSelectedDatamodel(){
//        return selectedDatamodel;
//    }


//    public ArrayList<Datamodel> getobjList(){
//        return repo.getDatamodel();
//    }//comemnted today(17 dec)

    //public ArrayList<Datamodel> getaddedList(){ return repo.setCategory()}


//    public Datamodel getobjDetails(String category){
//        return repo.getobjDetails(category);
//    }


//    public ArrayList<Datamodel> getDatamodel() {
//        return repo.getDatamodel();
//    }/comemnted today(17 dec)




}
