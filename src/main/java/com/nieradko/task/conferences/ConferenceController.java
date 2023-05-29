package com.nieradko.task.conferences;

import com.nieradko.task.reservation.ReservationDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/conferences")
public class ConferenceController {
    private final ConferenceService conferenceService;

    @GetMapping
    public ResponseEntity<List<ConferenceDto>> getConferences(){
        return conferenceService.getAllConferences();
    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<ReservationDto>> getAllRegisteredUsers() {
        return conferenceService.getAllRegisteredUsers();
    }


}
