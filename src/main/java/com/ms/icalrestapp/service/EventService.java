package com.ms.icalrestapp.service;

import com.ms.icalrestapp.model.CustomDate;
import com.ms.icalrestapp.model.EventModel;
import com.ms.icalrestapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final DateService dateService = new DateService();
    @Autowired
    EventRepository eventRepository;


    private CustomDate today() {
        return dateService.today();
    }

    private CustomDate nextWeek() {
        return dateService.nextWeek();
    }

    private CustomDate nextMonth() {
        return dateService.nextMonth();
    }

    private CustomDate dateParser(String date) {
        return dateService.dateParser(date);
    }

    public List<EventModel> returnAllEventsToday() {
        return eventRepository.findAllByEventStartDate(dateService.today());
    }


    public List<EventModel> returnAllEventsThisWeek() {
        return eventRepository.findAllByEventStartDateBetween(dateService.today(), dateService.nextWeek());
    }

    public List<EventModel> returnAllEventsThisMonth() {
        return eventRepository.findAllByEventStartDateBetween(dateService.today(), dateService.nextMonth());
    }

    public List<EventModel> returnAllPastEvents() {
        return eventRepository.findAllByEventStartDateIsLessThan(dateService.today());
    }
}
