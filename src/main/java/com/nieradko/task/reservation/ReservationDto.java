package com.nieradko.task.reservation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nieradko.task.conferences.ConferenceEntity;
import com.nieradko.task.lectures.LectureEntity;
import lombok.Getter;
import lombok.Setter;

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
