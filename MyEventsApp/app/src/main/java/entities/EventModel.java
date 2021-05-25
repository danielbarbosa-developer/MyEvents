package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class EventModel implements Serializable {

    public EventModel(String name, String date, String location){
        this.EventName = name;
        this.Date = date;
        this.Location = location;
    }

    public EventModel(int id, String eventName, String date, String location) {
        Id = id;
        EventName = eventName;
        Date = date;
        Location = location;
    }


    private int Id;

    private String EventName;

    private String Date;

    private String Location;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEventName(){
        return EventName;
    }

    public String getDate(){
        return Date;
    }

    public String getLocation(){
        return Location;
    }

    public void setEventName(String eventName){
        this.EventName = eventName;
    }

    public void setDate(String date){
        this.Date = date;
    }

    public void setLocation(String location){
        this.Location = location;
    }

    @Override
    public String toString(){
        return this.EventName + "\n" + this.Date.toString() + "\n" + this.Location;
    }
}
