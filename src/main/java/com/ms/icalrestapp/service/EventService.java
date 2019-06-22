package com.ms.icalrestapp.service;

import com.ms.icalrestapp.model.CustomDate;
import com.ms.icalrestapp.model.EventModel;
import com.ms.icalrestapp.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;


    private CustomDate today() {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateParser(date);
    }

    private CustomDate nextWeek() {
        String date = LocalDate.now().plusWeeks(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateParser(date);
    }

    private CustomDate nextMonth() {
        String date = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dateParser(date);
    }

    private CustomDate dateParser(String date) {
        String day = date.substring(0, 2);
        String month = date.substring(3, 5);
        String year = date.substring(6, 10);
        return new CustomDate(year, month, day);
    }

    public List<EventModel> returnAllEventsToday() {
        return eventRepository.findAllByEventStartDate(today());
    }


    public List<EventModel> returnAllEventsThisWeek() {
        return eventRepository.findAllByEventStartDateBetween(today(), nextWeek());
    }

    public List<EventModel> returnAllEventsThisMonth() {
        return eventRepository.findAllByEventStartDateBetween(today(), nextMonth());
    }

    public List<EventModel> returnAllPastEvents() {
        return eventRepository.findAllByEventStartDateIsLessThan(today());
    }
}
