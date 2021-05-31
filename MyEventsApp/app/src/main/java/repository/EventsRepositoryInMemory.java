package repository;

import abstractions.IRepository;
import android.icu.util.Calendar;
import entities.EventModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.time.LocalDate;
import java.util.List;

public class EventsRepositoryInMemory implements IRepository {

    private ArrayList<EventModel> eventsInMemory;

    private HashMap eventsDictionary; // This will be used to organize the events with a ID

    public EventsRepositoryInMemory(){
        eventsInMemory = new ArrayList<EventModel>();
    }

    public List<EventModel> GetAllEvents(){
        return eventsInMemory;
    }

    public void AddNewEvent(EventModel event){
        eventsInMemory.add(event);
    }

    public void EditEvent(int eventId, EventModel event){
        for(int i = 0; i < eventsInMemory.size(); i++){
            EventModel eventItem = eventsInMemory.get(i);
            if(eventItem.getId() == eventId){
                eventsInMemory.remove(eventItem);
                eventsInMemory.add(i, event);
            }
        }
    }

    public void DeleteEvent(int eventId){
        // TODO: Create a way to delete events from the list memory
    }
}
