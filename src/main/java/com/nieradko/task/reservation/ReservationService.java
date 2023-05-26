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

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final LectureRepository lectureRepository;
    private final ConferenceRepository conferenceRepository;
    private final ModelMapper modelMapper;

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

        if (lecture == null || !lecture.getConferences().equals(conference)){
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



}
