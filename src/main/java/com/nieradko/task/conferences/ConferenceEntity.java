package com.nieradko.task.conferences;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nieradko.task.lectures.LectureEntity;
import com.nieradko.task.reservation.ReservationEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "conference")
public class ConferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conferenceName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String endDate;

    @OneToMany(mappedBy = "conferences")
    private List<LectureEntity> allLectures;

    @OneToMany(mappedBy = "conference")
    private List<ReservationEntity> allReservations;
}
