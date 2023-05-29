package com.nieradko.task.lectures;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nieradko.task.conferences.ConferenceEntity;
import com.nieradko.task.reservation.ReservationEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "lecture")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class LectureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lectureName;

    private Integer personLimit;

    private Integer personEntriesLeft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conference_id", nullable = false)
    @JsonIgnore
    private ConferenceEntity conferences;

    @OneToMany(mappedBy = "lecture")
    @JsonIgnore
    private List<ReservationEntity> reserveLecture;
}
