package abstractions;

import entities.EventModel;

import java.util.ArrayList;
import java.util.List;

public interface IRepository {

    List<EventModel> GetAllEvents();

    void AddNewEvent(EventModel event);

    void EditEvent(int eventId, EventModel event);

    void DeleteEvent(int eventId);
}
