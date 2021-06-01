package services;

import abstractions.IRepository;
import android.content.Context;
import entities.EventModel;
import repository.EventsRepositoryInMemory;
import repository.EventsRepositorySQLite;

import java.util.ArrayList;
import java.util.List;

public class EventsHandler {

    private IRepository repository;

    public EventsHandler(Context context){
        this.repository = new EventsRepositorySQLite(context);
    }

    public List<EventModel> GetAllEvents(){
        return repository.GetAllEvents();
    }

    public void AddNewEvent(EventModel event){
        repository.AddNewEvent(event);
    }

    public void EditEvent(int eventId, EventModel event){
        repository.EditEvent(eventId, event);
    }

    public void DeleteEvent(int eventId){
        repository.DeleteEvent(eventId);
    }
}
