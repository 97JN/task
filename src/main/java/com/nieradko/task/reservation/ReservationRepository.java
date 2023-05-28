package com.nieradko.task.reservation;

import com.nieradko.task.conferences.ConferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByConference(ConferenceEntity conference);


    List<ReservationEntity> findByUsername(String username);


}
