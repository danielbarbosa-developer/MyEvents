package abstractions;

import entities.EventModel;
import entities.LocationModel;

import java.util.List;

public interface ILocalRepository {

    List<LocationModel> GetAllLocations();

    void AddNewLocation(LocationModel local);

    void EdiLocation(int localId, LocationModel local);

    void DeleteLocation(int localId);
}
