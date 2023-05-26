package com.nieradko.task.reservation;

import com.nieradko.task.lectures.LectureRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reserve")
public class ReservationController {
    private final LectureRepository lectureRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @PostMapping("/{conferenceId}/set/{lectureId}")
    public ResponseEntity<String> reserveLecture(
            @PathVariable Long conferenceId,
            @PathVariable Long lectureId,
            @RequestBody ReservationRequest request) {
       return reservationService.reserveLecture(conferenceId,lectureId,request);
    }

}

