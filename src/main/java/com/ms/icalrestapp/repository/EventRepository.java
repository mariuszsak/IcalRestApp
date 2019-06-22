package com.ms.icalrestapp.repository;

import com.ms.icalrestapp.model.CustomDate;
import com.ms.icalrestapp.model.EventModel;
import com.ms.icalrestapp.model.EventNamesOnly;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<EventModel, String> {
    List<EventModel> findAll();
    List<EventNamesOnly> findAllBy();
    EventModel findByEventName(String name);
    List<EventModel> findAllByEventStartDate(CustomDate customDate);
    List<EventModel> findAllByEventStartDateBetween(CustomDate start, CustomDate end);
    List<EventModel> findAllByEventStartDateIsLessThan (CustomDate today);
}
