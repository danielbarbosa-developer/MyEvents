package services;

import entities.EventModel;
import repository.EventsRepositoryInMemory;

import java.util.ArrayList;

public class EventsHandler {

    private EventsRepositoryInMemory repository;

    public EventsHandler(){
        this.repository = new EventsRepositoryInMemory();
    }

    public ArrayList<EventModel> GetAllEvents(){
        return repository.GetAllEvents();
    }

    public void AddNewEvent(EventModel event){
        repository.AddNewEvent(event);
    }

    public void EditEvent(int eventId, EventModel event){
        repository.EditEvent(eventId, event);
    }
}
