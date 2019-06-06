package com.ms.icalrestapp;

import com.ms.icalrestapp.model.EventModel;
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
    EventRepository eventRepository;

    @GetMapping("/all")
    public List<EventModel> all() {
        return eventRepository.findAll();
    }


    @RequestMapping(value = "/pass", consumes = "application/json", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public ResponseEntity<EventModel> getEvent(@RequestBody EventModel eventModel) {
        eventRepository.save(eventModel);
        return ResponseEntity.status(HttpStatus.OK).body(eventModel);
    }


}
