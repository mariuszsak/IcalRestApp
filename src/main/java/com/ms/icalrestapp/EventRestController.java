package com.ms.icalrestapp;

import com.ms.icalrestapp.model.EventModel;
import com.ms.icalrestapp.model.EventNamesOnly;
import com.ms.icalrestapp.repository.EventRepository;
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
    EventRepository eventRepository;

    @GetMapping("/all")
    public List<EventModel> all() {
        return eventRepository.findAll();
    }

    @GetMapping("/list")
    public List<EventNamesOnly> list(){
        return eventRepository.findAllBy();
    }

    @GetMapping("/detail/{name}")
    public EventModel showEvent(@PathVariable String name){
        return eventRepository.findByEventName(name);
    }

    @RequestMapping(value = "/pass", consumes = "application/json", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public ResponseEntity<EventModel> passEvent(@RequestBody EventModel eventModel) {
        eventRepository.save(eventModel);
        return ResponseEntity.status(HttpStatus.OK).body(eventModel);
    }


}
