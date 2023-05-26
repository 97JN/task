package com.nieradko.task.reservation;

import com.nieradko.task.conferences.ConferenceEntity;
import com.nieradko.task.lectures.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByConference(ConferenceEntity conference);


}
