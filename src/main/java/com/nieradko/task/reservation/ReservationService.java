package com.nieradko.task.reservation;

import com.nieradko.task.lectures.LectureEntity;
import com.nieradko.task.lectures.LectureRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final LectureRepository lectureRepository;

    public boolean isUsernameTaken(String username) {
        return reservationRepository.existsByUsername(username);
    }
    public boolean isEmailTaken(String email){
        return reservationRepository.existsByEmail(email);
    }

    public boolean isLectureFullyBooked(Long lectureId) {
        LectureEntity lecture = lectureRepository.findById(lectureId).orElse(null);
        return lecture != null && lecture.getPersonEntriesLeft() <= 0;
    }

    @Transactional
    public ResponseEntity<String> reserveLecture(Long lectureId, ReservationRequest request) {
        LectureEntity lecture = lectureRepository.findById(lectureId).orElse(null);
        if (lecture == null) {
            return new ResponseEntity<>("Lecture not found", HttpStatus.NOT_FOUND);
        }

        if (lecture.getPersonEntriesLeft() <= 0) {
            return new ResponseEntity<>("Lecture is fully booked", HttpStatus.CONFLICT);
        }

        ReservationEntity reservation = new ReservationEntity();
        reservation.setUsername(request.getUsername());
        reservation.setEmail(request.getEmail());
        reservation.setLecture(lecture);

        lecture.setPersonEntriesLeft(lecture.getPersonEntriesLeft() - 1);

        return new ResponseEntity<>("You have successfully signet to this lecture", HttpStatus.OK);

    }

}
