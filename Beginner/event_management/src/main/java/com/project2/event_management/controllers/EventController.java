package com.project2.event_management.controllers;

import com.project2.event_management.models.dtos.EventDto;
import com.project2.event_management.services.interfaces.EventInterface;
import com.project2.event_management.utils.handlers.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventInterface eventInterface;

    @GetMapping
    public ResponseEntity<?> getAllEvents(){
        return ResponseHandler.truCatchWrapper(() -> eventInterface.getAllEvents());
    }

    @PostMapping
    public ResponseEntity<?> addEvent(@RequestBody EventDto event){
        return ResponseHandler.truCatchWrapper(() -> eventInterface.addEvent(event));
    }

    @PutMapping
    public ResponseEntity<?> updateEvent(@RequestParam Long eventId,@RequestBody  EventDto event){
        return ResponseHandler.truCatchWrapper(() -> eventInterface.updateEvent(eventId, event));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteEvent(@RequestParam Long eventId){
        return ResponseHandler.truCatchWrapper(() -> eventInterface.deleteEvent(eventId));
    }
}
