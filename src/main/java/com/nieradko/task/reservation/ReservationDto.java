package com.nieradko.task.reservation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nieradko.task.conferences.ConferenceEntity;
import com.nieradko.task.lectures.LectureEntity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ReservationDto {

    private Long id;
    private String username;
    private String email;
    @JsonIgnore
    private LectureEntity lecture;
    @JsonIgnore
    private ConferenceEntity conference;

}
