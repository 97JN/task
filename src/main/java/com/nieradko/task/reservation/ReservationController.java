package com.nieradko.task.reservation;

import com.nieradko.task.lectures.LectureEntity;
import com.nieradko.task.lectures.LectureRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reserve")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping("/{conferenceId}/set/{lectureId}")
    public ResponseEntity<String> reserveLecture(
            @PathVariable Long conferenceId,
            @PathVariable Long lectureId,
            @RequestBody ReservationRequest request) {
        return reservationService.reserveLecture(conferenceId, lectureId, request);
    }

    @GetMapping("/{username}/lectures")
    public ResponseEntity<List<LectureEntity>> getLecturesForUsers(@PathVariable String username) {
        List<LectureEntity> lectures = reservationService.getLecturesForUsers(username);
        return new ResponseEntity<>(lectures, HttpStatus.OK);
    }

    @DeleteMapping("/cancel/{username}/reservation/{reservationId}")
    public ResponseEntity<String> cancelUserReservation(
            @PathVariable String username,
            @PathVariable Long reservationId){
        return reservationService.cancelUserReservation(username,reservationId);
    }


}

