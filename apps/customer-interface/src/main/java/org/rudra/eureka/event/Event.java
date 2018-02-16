package org.rudra.eureka.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {

    private int eventUID;
    private String eventName;
    private String eventLocation;
    private String eventType;

    public Event() {
    }

    public Event(int eventUID, String eventName, String eventLocation, String eventType) {
        this.eventUID = eventUID;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventType = eventType;
    }

    public int getEventUID() {
        return eventUID;
    }

    public void setEventUID(int eventUID) {
        this.eventUID = eventUID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
