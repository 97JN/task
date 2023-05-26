package com.nieradko.task.reservation;

import com.nieradko.task.conferences.ConferenceEntity;
import com.nieradko.task.lectures.LectureEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", nullable = true)
    private LectureEntity lecture;
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "conference_id", nullable = true)
    private ConferenceEntity conference;
}
