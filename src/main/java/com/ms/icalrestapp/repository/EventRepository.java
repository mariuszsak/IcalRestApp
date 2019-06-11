package com.ms.icalrestapp.repository;

import com.ms.icalrestapp.model.EventModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<EventModel, String> {
    List<EventModel> findAll();
}
