package com.nieradko.task.reservation;

import com.nieradko.task.conferences.ConferenceEntity;
import com.nieradko.task.conferences.ConferenceRepository;
import com.nieradko.task.lectures.LectureEntity;
import com.nieradko.task.lectures.LectureRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final LectureRepository lectureRepository;
    private final ConferenceRepository conferenceRepository;

    @Transactional
    public ResponseEntity<String> reserveLecture(Long conferenceId, Long lectureId, ReservationRequest request) {

        ConferenceEntity conference = conferenceRepository.findById(conferenceId).orElse(null);
        LectureEntity lecture = lectureRepository.findById(lectureId).orElse(null);

        boolean isConferenceTaken = reservationRepository.existsByConference(conference);
        boolean isUsernameTaken = reservationRepository.existsByUsername(request.getUsername());
        boolean isEmailTaken = reservationRepository.existsByEmail(request.getEmail());

        if (conference == null) {
            return new ResponseEntity<>("There is no conference with given ID", HttpStatus.NOT_FOUND);
        }

        if (lecture == null || !lecture.getConferences().equals(conference)) {
            return new ResponseEntity<>("There is no lecture with given ID", HttpStatus.NOT_FOUND);
        }
        if (lecture.getPersonEntriesLeft() <= 0) {
            return new ResponseEntity<>("We are sorry but lecture is fully booked", HttpStatus.CONFLICT);
        }

        if (isConferenceTaken) {
            if (isUsernameTaken && isEmailTaken) {
                return new ResponseEntity<>("You can sign only for 1 lecture during conference", HttpStatus.CONFLICT);
            } else if (!isUsernameTaken && isEmailTaken) {
                return new ResponseEntity<>("Email is already taken", HttpStatus.CONFLICT);
            } else if (isUsernameTaken) {
                return new ResponseEntity<>("Username is already taken", HttpStatus.CONFLICT);
            }
        }

        ReservationEntity reservation = new ReservationEntity();
        reservation.setUsername(request.getUsername());
        reservation.setEmail(request.getEmail());
        reservation.setLecture(lecture);
        reservation.setConference(conference);
        reservationRepository.save(reservation);

        lecture.setPersonEntriesLeft(lecture.getPersonEntriesLeft() - 1);

        return new ResponseEntity<>("You have successfully signed up for this lecture", HttpStatus.OK);
    }

    public List<LectureEntity> getLecturesForUsers(String username) {
        List<ReservationEntity> reservations = reservationRepository.findByUsername(username);
        List<LectureEntity> lectures = new ArrayList<>();

        for (ReservationEntity reservation : reservations) {
            LectureEntity lecture = reservation.getLecture();
            if (lecture != null) {
                lectures.add(lecture);
            }
        }

        return lectures;
    }

    public ResponseEntity<String> canselUserReservation(String username, Long reservationId) {

        Optional<ReservationEntity> reservation = reservationRepository.findById(reservationId);
        Long lectureId = reservation.map(ReservationEntity::getLecture)
                .map(LectureEntity::getId).orElse(null);

        LectureEntity lecture = null;
        if (lectureId != null) {
            lecture = lectureRepository.findById(lectureId).orElse(null);
        }

        if (reservation.isPresent()) {
            ReservationEntity reservations = reservation.get();
            if (reservations.getUsername() != null && reservations.getUsername().equals(username)) {
                reservationRepository.delete(reservations);
                if (lecture != null) {
                    lecture.setPersonEntriesLeft(lecture.getPersonEntriesLeft() + 1);
                    ReservationEntity cancelReservation = new ReservationEntity();
                    cancelReservation.setLecture(lecture);
                    reservationRepository.save(cancelReservation);
                }
                return new ResponseEntity<>("Reservation has been canceled", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User is not assigned to the specified reservation", HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity<>("There is no reservation with the given ID", HttpStatus.NOT_FOUND);
        }
    }
}



