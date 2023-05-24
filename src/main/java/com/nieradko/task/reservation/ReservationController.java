package com.nieradko.task.reservation;

import com.nieradko.task.lectures.LectureEntity;
import com.nieradko.task.lectures.LectureRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reserve")
public class ReservationController {
    private final LectureRepository lectureRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @PostMapping("/{lectureId}")
    public ResponseEntity<String> reserveLecture(@PathVariable Long lectureId, @RequestBody ReservationRequest request) {
        if (reservationService.isUsernameTaken(request.getUsername()) && !reservationService.isEmailTaken(request.getEmail())) {
            return new ResponseEntity<>("Username is already taken",HttpStatus.OK);
        }

        if (reservationService.isLectureFullyBooked(lectureId)) {
            return new  ResponseEntity<>("Lecture is fully booked",HttpStatus.BAD_REQUEST);
        }

        reservationService.reserveLecture(lectureId, request.getUsername(), request.getEmail());
        return new ResponseEntity<>("You have successfully signed to this lecture", HttpStatus.OK);
    }
}

