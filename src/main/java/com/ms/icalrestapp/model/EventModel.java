package com.ms.icalrestapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document(collection = "events")
public class EventModel {

    @Id
    private String _id;
    private String eventName;
    //    private String eventStartDate;
    private CustomDate eventStartDate;
    private CustomTime eventStartTime;
    private CustomDate eventEndDate;
    //    private String eventEndDate;
    private CustomTime eventEndTime;
    private String eventLocation;
    private String eventDescription;

    public EventModel() {
    }

    public EventModel(String _id, String eventName, CustomDate eventStartDate, CustomTime eventStartTime, CustomDate eventEndDate, CustomTime eventEndTime, String eventLocation, String eventDescription) {
        this._id = _id;
        this.eventName = eventName;
        this.eventStartDate = eventStartDate;
        this.eventStartTime = eventStartTime;
        this.eventEndDate = eventEndDate;
        this.eventEndTime = eventEndTime;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public CustomDate getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(CustomDate eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public CustomTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(CustomTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public CustomDate getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(CustomDate eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public CustomTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(CustomTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }
}
