package com.nieradko.task.conferences;

import com.nieradko.task.lectures.LectureDto;
import com.nieradko.task.reservation.ReservationDto;
import com.nieradko.task.reservation.ReservationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@AllArgsConstructor
public class ConferenceController {
    private final ConferenceService conferenceService;
    private final ReservationService reservationService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ConferenceDto>> getConferences(){
        return conferenceService.getAllConferences();
    }
    @GetMapping("/allUsers")
    public ResponseEntity<List<ReservationDto>> getAllRegisteredUsers() {
        return conferenceService.getAllRegisteredUsers();
    }

}
