package services;

import abstractions.ILocalRepository;
import android.content.Context;
import entities.EventModel;
import entities.LocationModel;
import repository.LocationsRepositorySQLite;

import java.util.List;

public class LocationsHandler {
    private ILocalRepository repository;

    public LocationsHandler(Context context){
        this.repository = new LocationsRepositorySQLite(context);
    }

    public List<LocationModel> GetAllLocations(){
        return repository.GetAllLocations();
    }

    public void AddNewLocation(LocationModel local){
        repository.AddNewLocation(local);
    }

    public void EditLocation(int localId, LocationModel local){
        repository.EdiLocation(localId, local);
    }

    public void DeleteLocation(int localId){
        repository.DeleteLocation(localId);
    }
}
