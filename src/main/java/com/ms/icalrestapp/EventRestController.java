package com.ms.icalrestapp;

import com.ms.icalrestapp.model.CustomDate;
import com.ms.icalrestapp.model.EventModel;
import com.ms.icalrestapp.model.EventNamesOnly;
import com.ms.icalrestapp.repository.EventRepository;
import com.ms.icalrestapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
public class EventRestController {

    @Autowired
    EventService eventService;

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/all")
    public List<EventModel> all() {
        return eventRepository.findAll();
    }

    @GetMapping("/list")
    public List<EventNamesOnly> list() {
        return eventRepository.findAllBy();
    }

    @GetMapping("/list/1")
    public List<EventModel> showEventsInPeriod1() {
        return eventService.returnAllEventsToday();
    }

    @GetMapping("/list/7")
    public List<EventModel> showEventsInPeriod7() {
        return eventService.returnAllEventsThisWeek();
    }

    @GetMapping("/list/30")
    public List<EventModel> showEventsInPeriod30() {
        return eventService.returnAllEventsThisMonth();
    }

    @GetMapping("/list/past")
    public List<EventModel> showEventsInPast() {
        return eventService.returnAllPastEvents();
    }


    @GetMapping("/detail/{name}")
    public EventModel showEvent(@PathVariable String name) {
        return eventRepository.findByEventName(name);
    }

    @RequestMapping(value = "/pass", consumes = "application/json", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public ResponseEntity<EventModel> passEvent(@RequestBody EventModel eventModel) {
        eventRepository.save(eventModel);
        return ResponseEntity.status(HttpStatus.OK).body(eventModel);
    }


}
